package org.adaschool.api.service.document;

import java.util.List;
import java.util.Optional;

import org.adaschool.api.repository.document.Document;
import org.adaschool.api.repository.product.Product;
import org.springframework.stereotype.Service;

@Service
public interface DocumentService {

    Document save(Document document);

    Optional<Document> findById(String id);

    List<Document> all();

    void deleteById(String id);

    Document update(Document Document, String DocumentId);
    
}
