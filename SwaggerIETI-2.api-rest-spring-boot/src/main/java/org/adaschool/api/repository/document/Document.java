package org.adaschool.api.repository.document;

import org.bson.types.ObjectId;

public class Document {

    private ObjectId id;
    private String name;
    private String size;

    public Document(ObjectId id, String name, String size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public Document(DocumentDto documentDto) {
        this.id = documentDto.getId();
        this.name = documentDto.getName();
        this.size = documentDto.getSize();
    }

    public Document(){
        this.id = null;
        this.name = "";
        this.size = "";
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
}
