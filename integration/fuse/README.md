Running the Buienradar service provider in Fuse
===============================================
Author: PK

Level: Beginner

Technologies: CXF, OSGi, Fuse

Summary: Demonstrates how to install the Buienradar service provider in fuse

Target Framework: Fuse

System requirements
-------------------
This project has been tested running using the following dependencies:

* Maven 3.3.9
* JDK 1.8.0_102
* JBoss Fuse 6.2.1

**Note:** Combinations of other version might work but have not been tested

Installing the bundle
---------------------
To execute all scripts to install the buienradar service provider enter the following command in the Karaf console:

    source mvn:org.vpk.rmt.integration/fuse/1.0.0-SNAPSHOT/fuse/1-clean-fabric
**Assumption:** Project compiled and installed in the local Maven repository

Using the bundle
----------------

### Browsing the metadata provided by the services

The full list of all registered CXF web services is available at:

    http://localhost:8183/cxf
After you deployed the buienradar service provider, you will see the following endpoint address appear in the 'Available RESTful services' section:

    http://localhost:8183/cxf/rmt
**Note:** This endpoint address cannot be browsed as it is not accessible by design

Just below it, you'll find a link to the WADL describing all the root resources:

    http://localhost:8183/cxf/rmt?_wadl

### Browsing the data provided by the services

Currently the buienradar provider supports the following services:

    http://localhost:8183/cxf/rmt/buienradar/nl/weatherdata/actual/region/Eindhoven,Venlo
    http://localhost:8183/cxf/rmt/buienradar/nl/weatherdata/expected/today
    http://localhost:8183/cxf/rmt/buienradar/nl/weatherdata/expected/next/5
**Note:** Data provided by http://xml.buienradar.xml
