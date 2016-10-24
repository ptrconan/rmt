package org.vpk.rmt.serviceproviders.buienradar.backend.impl;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class BuienradarBackEndRoute extends RouteBuilder {

	private Processor transformResponseProcessor;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
	}

    public void setTransformResponseProcessor(Processor transformResponseProcessor) {
        this.transformResponseProcessor = transformResponseProcessor;
    }
}
