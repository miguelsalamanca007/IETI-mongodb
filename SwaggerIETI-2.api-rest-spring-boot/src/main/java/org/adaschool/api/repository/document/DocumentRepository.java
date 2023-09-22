package org.adaschool.api.repository.document;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Document, String>{
    
}
