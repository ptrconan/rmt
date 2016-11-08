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

In studying this quick start you will learn:

* how to configure the JAX-RS web services by using the blueprint configuration file.
* how to use JAX-RS annotations to map methods and classes to URIs
* how to use JAXB annotations to define beans and output XML responses
* how to use the JAX-RS API to create HTTP responses

For more information see:

* <https://access.redhat.com/site/documentation/JBoss_Fuse/> for more information about using JBoss Fuse

System requirements
-------------------
Before building and running this quick start you need:

* Maven 3.1.1 or higher
* JDK 1.7 or 1.8
* JBoss Fuse 6

Build and Deploy the Quickstart
-------------------------------

1. Change your working directory to `rest` directory.
* Run `mvn clean install` to build the quickstart.
* Start JBoss Fuse 6 by running bin/fuse (on Linux) or bin\fuse.bat (on Windows).
* In the JBoss Fuse console, enter the following command:

        osgi:install -s mvn:org.jboss.quickstarts.fuse/cxf-rest/6.2.1.redhat-084

* Fuse should give you an id when the bundle is deployed
* You can check that everything is ok by issuing  the command:

        osgi:list
   your bundle should be present at the end of the list


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

You can use any browser to perform a HTTP GET.  This allows you to very easily test a few of the services that are defined:

Use this URL to display the JSON representation of the weather information presented by the stations in the regions Eindhoven or Venlo:

    http://localhost:9000/cxf/rmt/buienradar/nl/Eindhoven
    http://localhost:9000/cxf/rmt/buienradar/nl/Venlo



**Note:** if you use Safari, you will only see the text elements but not the XML tags - you can view the entire document with 'View Source'

### To run the tests:

In this quick start project, we also provide integration tests which perform a few HTTP requests to test our Web services. We
created a Maven `test` profile to allow us to run tests code with a simple Maven command after having deployed the bundle to Fuse:

1. Change to the `rest` directory.
2. Run the following command:

        mvn -Ptest
        
The tests in `src/test/java/org.jboss.quickstarts.fuse.rest/CrmTest`  make a sequence of RESTful invocations and displays the results.


