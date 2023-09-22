package org.adaschool.api.service.document;

import java.util.List;
import java.util.Optional;

import org.adaschool.api.repository.document.Document;
import org.adaschool.api.repository.document.DocumentRepository;
import org.adaschool.api.repository.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceMap implements DocumentService{

    @Autowired DocumentRepository documentRepository;

    @Override
    public Document save(Document document) {
        documentRepository.save(document);
        return document;
    }

    @Override
    public Optional<Document> findById(String id) {
        return documentRepository.findById(id);
    }

    @Override
    public List<Document> all() {
        return documentRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        documentRepository.deleteById(id);
    }

    @Override
    public Document update(Document Document, String DocumentId) {
        Optional<Document> _document = documentRepository.findById(DocumentId);
        Document.setName(_document.get().getName());
        Document.setSize(_document.get().getSize());
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
