package org.adaschool.api.controller.document;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.adaschool.api.exception.DocumentNotFoundException;
import org.adaschool.api.repository.document.Document;
import org.adaschool.api.repository.document.DocumentDto;
import org.adaschool.api.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/documents/")
public class DocumentController {
private final DocumentService documentService;

    public DocumentController(@Autowired DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody DocumentDto documentDto) {
        Document document = documentService.save(new Document(documentDto));
        URI createdDocumentUri = URI.create("/v1/documents/" + document.getId());
        return ResponseEntity.created(createdDocumentUri).body(document);
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.all();
        return ResponseEntity.ok(documents);
    }

    @GetMapping("{id}")
    public ResponseEntity<Document> findDocumentById(@PathVariable("id") String id) {
        Optional<Document> document = documentService.findById(id);
        if (document.isPresent()) {
            return ResponseEntity.ok(document.get());
        } else {
            throw new DocumentNotFoundException(id);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Document> updateDocument(@RequestBody DocumentDto documentDto, @PathVariable String id) {
        Optional<Document> documentOpt = documentService.findById(id);
        if (documentOpt.isPresent()) {
            Document document = documentOpt.get();
            document.setId(documentDto.getId());
            document.setName(documentDto.getName());
            document.setSize(documentDto.getSize());
            documentService.save(document);
            return ResponseEntity.ok(document);
        } else {
            throw new DocumentNotFoundException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable("id") String id) {
        Optional<Document> documentOpt = documentService.findById(id);
        if (documentOpt.isPresent()) {
            documentService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new DocumentNotFoundException(id);
        }
    }
}
