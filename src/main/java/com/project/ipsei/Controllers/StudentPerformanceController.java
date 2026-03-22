package com.project.ipsei.Controllers;
import com.project.ipsei.Model.StudentPerformance;
import com.project.ipsei.Services.StudentPerformanceServiceImpl;
import com.project.ipsei.Entities.StudentPerformance;
import com.project.ipsei.Services.StudentPerformanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * TODO: Mover este controller para o pacote correto (src/main/java).
 *
 * Controllers não devem estar na pasta "resources", pois:
 * - Não fazem parte de recursos estáticos/configuração
 * - Podem não ser corretamente detectados pelo component scan do Spring
 *
 * A estrutura deve seguir o padrão:
 * src/main/java/.../controller
 *
 * Objetivo: manter a organização do projeto e aderência às convenções do Spring Boot.
 */
@RestController
@RequestMapping("/api/performance")
public class StudentPerformanceController {

    private final StudentPerformanceServiceImpl service;

    public StudentPerformanceController(StudentPerformanceServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/students")
    /*
     * TODO: Não utilizar entidade como @RequestBody.
     *
     * Refatorar para:
     * - Introduzir DTO de criação com validações (Jakarta Validation)
     * - Remover validações manuais do controller
     * - Realizar o mapeamento DTO -> entidade de forma explícita
     *
     * Motivo: reduzir acoplamento, evitar exposição indevida de campos e padronizar o contrato da API.
     */
    public ResponseEntity<StudentPerformance> createStudentPerformance(@RequestBody StudentPerformance request) {
        if (request.getStudentName() == null || request.getScore() == null) {
            return ResponseEntity.badRequest().build();
        }
        StudentPerformance saved = service.create(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentPerformance>> listStudentPerformance() {
        return ResponseEntity.ok(service.listByScoreRank());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentPerformance> getStudentPerformance(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
