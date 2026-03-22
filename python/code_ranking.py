class Student:
    def __init__(self, name, course):
        self.name = name
        self.course = course
        self.performances = [] 
        self.documents = []

    def compute_total_score(self):
        return sum(p.score for p in self.performances)

class Performance:
    def __init__(self, score, term):
        self.score = score
        self.term = term
        self.rank = None
        self.rank = None  

# TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!