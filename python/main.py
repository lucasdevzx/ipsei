from code_ranking import Student, Performance
from code_upload import Institution
from ranking_service import RankingService

# Exemplo de uso do sistema de ranking em Python
if __name__ == "__main__":
    # Cria uma instância da instituição que irá gerenciar uploads
    institution = Institution("Universidade XYZ")

    # Cria instâncias de estudantes com nome e curso
    student1 = Student("João", "Engenharia")
    student2 = Student("Maria", "Medicina")

    # Adiciona performances históricas aos estudantes (simulando dados existentes)
    student1.performances.append(Performance(85, "2023-1"))
    student1.performances.append(Performance(90, "2023-2"))
    student2.performances.append(Performance(95, "2023-1"))

    # Simula o upload de documentos pela instituição, que adiciona scores automaticamente
    institution.upload_file_to_student(student1, "/path/to/file1.pdf", "Assignment")
    institution.upload_file_to_student(student2, "/path/to/file2.pdf", "Project")

    # Executa o serviço de ranking para ordenar estudantes por score total
    ranking_service = RankingService()
    ranked_students = ranking_service.rank_students([student1, student2])

    # Exibe o ranking final com nome, rank e score total
    for student in ranked_students:
        print(f"{student.name}: Rank {student.rank}, Score {student.compute_total_score()}")

# TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!