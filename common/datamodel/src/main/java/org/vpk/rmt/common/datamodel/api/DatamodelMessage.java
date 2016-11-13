package org.vpk.rmt.common.datamodel.api;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "headers",
    "payload"
})
public abstract class DatamodelMessage {

    @JsonProperty("headers")
    private MessageHeaders headers;
    /**
     * 
     */
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The headers
     */
    @JsonProperty("headers")
    public MessageHeaders getHeaders() {
        return headers;
    }

    /**
     * 
     * @param headers
     *     The headers
     */
    @JsonProperty("headers")
    public void setHeaders(MessageHeaders headers) {
        this.headers = headers;
    }

    /**
     * 
     * @return
     *     The payload
     */
    @JsonProperty("payload")
    public abstract Object getPayload() ;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(headers).append(getPayload()).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DatamodelMessage) == false) {
            return false;
        }
        DatamodelMessage rhs = ((DatamodelMessage) other);
        return new EqualsBuilder().append(headers, rhs.headers).append(getPayload(), rhs.getPayload()).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
