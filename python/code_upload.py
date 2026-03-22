class Document:
    def __init__(self, file_path, doc_type="General"):
        self.file_path = file_path
        self.doc_type = doc_type
        self.upload_date = None  # Pode ser datetime.now() para timestamp
        self.score_contribution = 0  # Pontuação adicionada ao estudante baseada no tipo de documento

class Institution:
    def __init__(self, name):
        self.name = name

    def upload_file_to_student(self, student, file_path, doc_type="General"):
        # Cria um novo documento com o tipo especificado
        new_doc = Document(file_path, doc_type)
        # Define a contribuição de score baseada no tipo de documento
        if doc_type == "Assignment":
            new_doc.score_contribution = 10
        elif doc_type == "Project":
            new_doc.score_contribution = 20
        else:
            new_doc.score_contribution = 5
        # Adiciona o documento à lista do estudante
        student.documents.append(new_doc)
        # Cria uma nova performance baseada no upload e adiciona ao estudante
        from code_ranking import Performance
        new_performance = Performance(new_doc.score_contribution, "Current Term")
        student.performances.append(new_performance)
        print(f"Arquivo {doc_type} enviado para {student.name}, score +{new_doc.score_contribution}")

        # TODAS AS HASHTAGS QUE EU USAR, SÃO PARA EXPLICAR A VOCÊS, ERICKSON E LUCAS COMO ESTOU IMPLEMENTANDO PYTHON PARA O CÓDIGO DE VOCÊS!