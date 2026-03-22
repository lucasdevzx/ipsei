from code_ranking import Student

class RankingService:
    def __init__(self):
        pass

    def rank_students(self, students):
        # Ordena estudantes por score total decrescente
        sorted_students = sorted(students, key=lambda s: s.compute_total_score(), reverse=True)
        for rank, student in enumerate(sorted_students, start=1):
            student.rank = rank
        return sorted_students
    
# TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!