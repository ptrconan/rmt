#!/bin/bash
VERSION=${project.version}

echo "*** Remove existing child containers ..."
bin/client "fabric:container-delete map-*"

echo "*** Stop root container ..."
bin/stop
sleep 5

echo "*** Remove data and instances directories ..."
rm -fr data/ instances/

echo "*** Start cleaned fuse instance ..."
bin/start

echo "*** Create new fabric ..."
bin/client -r 20 "fabric:create -g manualip -r manualip -m 127.0.0.1 --profile fabric --clean --wait-for-provisioning"

echo "*** Configure nexus repository ..."
bin/client -r 20 "profile-edit --pid io.fabric8.agent/org.ops4j.pax.url.mvn.repositories=http://localhost:8081/nexus/content/groups/public@id=vpk-nexus default"

echo "*** Run fuse fabric provisioning script ..."
bin/client -r 20 "source mvn:org.vpk.rmt.integration/fuse/$VERSION/fuse/2-install-profiles local"
