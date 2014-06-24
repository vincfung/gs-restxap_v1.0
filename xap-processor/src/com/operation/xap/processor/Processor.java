package com.operation.xap.processor;

import org.openspaces.events.adapter.SpaceDataEvent;
import org.openspaces.events.*;
import org.openspaces.events.polling.*;

import com.operation.rest.common.Message;
import java.util.logging.Logger;


/**
 * The processor is passed interesting Objects from its associated PollingContainer
 * <p>The PollingContainer removes objects from the GigaSpace that match the criteria
 * specified for it.
 * <p>Once the Processor receives each Object, it modifies its state and returns it to
 * the PollingContainer which writes them back to the GigaSpace
 * <p/>
 * <p>The PollingContainer is configured in the pu.xml file of this project
 */
@EventDriven @Polling
public class Processor {
    Logger logger=Logger.getLogger(this.getClass().getName());

    /**
     * Process the given Message and return it to the caller.
     * This method is invoked using OpenSpaces Events when a matching event
     * occurs.
     */

    @SpaceDataEvent
    public void processMessage(Message msg) {
        logger.info("Processor PROCESSING: " + msg);
        
    }

    public Processor() {
        logger.info("Processor instantiated, waiting for messages feed...");
    }

}
