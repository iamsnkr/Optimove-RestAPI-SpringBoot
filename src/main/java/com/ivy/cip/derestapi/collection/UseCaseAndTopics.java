package com.ivy.cip.derestapi.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Builder
@Document(collection = "UseCaseAndTopics")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UseCaseAndTopics {
    @Id
    private String id;
    private String source;
    private String detination;
    private String optimoveInstance;
    private String usecase;
    private List<String> customerAttrs;

    public UseCaseAndTopics(String id, String source, String detination, String optimoveInstance, String usecase, List<String> customerAttrs) {
        this.id = id;
        this.source = source;
        this.detination = detination;
        this.optimoveInstance = optimoveInstance;
        this.usecase = usecase;
        this.customerAttrs = customerAttrs;
    }
}
