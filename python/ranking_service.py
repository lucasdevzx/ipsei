from code_ranking import Student

class RankingService:
    def __init__(self):
        pass

    def rank_students(self, students):
        # Ordena a lista de estudantes por score total em ordem decrescente (maior score primeiro)
        sorted_students = sorted(students, key=lambda s: s.compute_total_score(), reverse=True)
        # Atribui ranks sequenciais (1, 2, 3...) aos estudantes ordenados
        for rank, student in enumerate(sorted_students, start=1):
            student.rank = rank
        # Retorna a lista ordenada com ranks atribuídos
        return sorted_students
    
# TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!