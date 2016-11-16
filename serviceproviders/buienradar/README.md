buienradar: Demonstrates how to create a REST Web service
===============================================
Author: PK  
Level: Beginner  
Technologies: Fuse, OSGi, CXF  
Summary: This quickstart demonstrates how to create a RESTful (JAX-RS) web service using CXF and expose it through the OSGi HTTP Service.
Target Product: Fuse  
Source: <https://github.com/jboss-fuse/quickstarts>

What is it?
-----------
This quick start demonstrates how to create a RESTful (JAX-RS) web service using CXF and expose it with the OSGi HTTP Service.

System requirements
-------------------
Before building and running this bundle you need:

* Maven 3.1.1 or higher
* JDK 1.8
* JBoss Fuse 6

Use the bundle
--------------

### Browsing Web service metadata

A full listing of all CXF web services is available at

    http://localhost:9000/

After you deployed this quick start, you will see the following endpoint address appear in the 'Available RESTful services' section:

    http://localhost:8181/cxf/crm
**Note:**: Don't try to access this endpoint address from browser, as it's inaccessible by design

Just below it, you'll find a link to the WADL describing all the root resources:

    http://localhost:8181/cxf/crm?_wadl

You can also look at the more specific WADL, the only that only lists information about 'customerservice' itself:

    http://localhost:8181/cxf/crm/customerservice?_wadl&_type=xml

### Access services using a web browser

You can use any browser to perform a HTTP GET. This allows you to very easily test a few of the services that are defined:

Use this URL to display the JSON representation of the weather information presented by http://xml.buienradar.nl:

    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/verwachtingMeerdaags
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/verwachtingVandaag
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/actueel_weer
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/actueel_weer/buienindex
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/actueel_weer/buienradar
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/actueel_weer/weerstations
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/actueel_weer/weerstations/weerstation/6275
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/actueel_weer/weerstations/weerstation?id=6275
    http://localhost:9000/cxf/rmt/buienradar/nl/weergegevens/actueel_weer/weerstations/weerstation?stationcode=6275


