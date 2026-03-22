from code_ranking import Student, Performance
from code_upload import Institution
from ranking_service import RankingService

# Exemplo de uso
if __name__ == "__main__":
    # Criar instituição
    institution = Institution("Universidade XYZ")

    # Criar estudantes
    student1 = Student("João", "Engenharia")
    student2 = Student("Maria", "Medicina")

    # Adicionar performances
    student1.performances.append(Performance(85, "2023-1"))
    student1.performances.append(Performance(90, "2023-2"))
    student2.performances.append(Performance(95, "2023-1"))

    # Simular upload de documentos
    institution.upload_file_to_student(student1, "/path/to/file1.pdf", "Assignment")
    institution.upload_file_to_student(student2, "/path/to/file2.pdf", "Project")

    # Ranking
    ranking_service = RankingService()
    ranked_students = ranking_service.rank_students([student1, student2])

    # Exibir ranking
    for student in ranked_students:
        print(f"{student.name}: Rank {student.rank}, Score {student.compute_total_score()}")

# TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!