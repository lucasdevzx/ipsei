class Student:
    def __init__(self, name, course):
        self.name = name
        self.course = course
        self.performances = []  # Lista de objetos Performance para armazenar histórico de pontuações
        self.documents = []  # Lista de documentos upados pela instituição

    def compute_total_score(self):
        # Calcula a soma total dos scores de todas as performances do estudante
        return sum(p.score for p in self.performances)

class Performance:
    def __init__(self, score, term):
        self.score = score
        self.term = term
        self.rank = None  # Rank atribuído pelo serviço de ranqueamento (1, 2, 3...)
        self.rank = None  

# TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!