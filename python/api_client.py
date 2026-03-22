import requests

class StudentPerformanceAPI:
    def __init__(self, base_url="http://localhost:8080"):
        # Inicializa o cliente API com a URL base do servidor Java
        self.base_url = base_url

    def get_ranked_students(self):
        # Faz requisição GET para obter lista de estudantes ranqueados do Java
        response = requests.get(f"{self.base_url}/api/performance/students")
        if response.status_code == 200:
            return response.json()
        else:
            print("Erro ao buscar estudantes:", response.status_code)
            return []

    def save_performance(self, student_name, course, term, score, reward=""):
        # Faz requisição POST para salvar uma nova performance no Java
        data = {
            "studentName": student_name,
            "course": course,
            "term": term,
            "score": score,
            "reward": reward
        }
        response = requests.post(f"{self.base_url}/api/performance/students", json=data)
        if response.status_code == 201:
            return response.json()
        else:
            print("Erro ao salvar performance:", response.status_code)
            return None
        
# TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!