# Face Detection com OpenCV

Um projeto Java simples para detecção facial usando OpenCV e classificadores Haar Cascade.

## 🎯 Funcionalidades

- Detecção automática de rostos em imagens
- Desenho de retângulos verdes ao redor dos rostos detectados
- Salvamento da imagem processada
- Interface de linha de comando simples

## 🛠️ Tecnologias Utilizadas

- **Java 11+**
- **Maven** - Gerenciamento de dependências
- **OpenCV 4.9.0** (ByteDeco) - Biblioteca de visão computacional
- **Haar Cascade Classifier** - Algoritmo de detecção facial

## 📋 Pré-requisitos

- Java 11 ou superior
- Maven 3.6+
- Sistema operacional: Windows, macOS ou Linux

## 🚀 Instalação e Execução

### 1. Clone ou baixe o projeto
```bash
git clone <url-do-repositorio>
cd FaceDetection
```

### 2. Compile o projeto
```bash
mvn compile
```

### 3. Adicione uma imagem para teste
Coloque uma imagem chamada `foto.jpg` na pasta raiz do projeto.

### 4. Execute o programa
```bash
mvn exec:java -Dexec.mainClass="com.example.FaceDetectionExample"
```

## 📁 Estrutura do Projeto

```
FaceDetection/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/
│       │       └── FaceDetectionExample.java
│       └── resources/
├── haarcascade_frontalface_default.xml
├── foto.jpg (sua imagem de entrada)
├── foto_com_deteccoes.jpg (imagem processada)
├── pom.xml
└── README.md
```

## 💡 Como Usar

1. **Prepare sua imagem**: Coloque uma imagem JPG na pasta raiz com o nome `foto.jpg`
2. **Execute o programa**: Use o comando Maven mostrado acima
3. **Veja os resultados**: 
   - O console mostrará quantos rostos foram detectados
   - Uma nova imagem `foto_com_deteccoes.jpg` será criada com retângulos verdes nos rostos

## 📊 Exemplo de Saída

```
Número de rostos detectados: 2
Imagem salva com as detecções.
```

## ⚙️ Configuração

### Dependências Maven

O projeto usa a seguinte dependência principal:

```xml
<dependency>
    <groupId>org.bytedeco</groupId>
    <artifactId>opencv-platform</artifactId>
    <version>4.9.0-1.5.10</version>
</dependency>
```

### Classificador Haar Cascade

O arquivo `haarcascade_frontalface_default.xml` é baixado automaticamente do repositório oficial do OpenCV e contém o modelo treinado para detecção de rostos frontais.

## 🔧 Personalização

### Alterar a imagem de entrada
Modifique a linha no código:
```java
Mat image = imread("foto.jpg");
```

### Alterar a cor dos retângulos
Modifique o parâmetro Scalar:
```java
rectangle(image, rect, new Scalar(0, 255, 0, 0), 3, LINE_8, 0);
// RGB: (0, 255, 0) = Verde
```

### Ajustar sensibilidade da detecção
Adicione parâmetros ao método `detectMultiScale`:
```java
faceDetector.detectMultiScale(image, faceDetections, 1.1, 3, 0, new Size(30, 30), new Size());
```

## 🐛 Solução de Problemas

### "Não foi possível carregar a imagem"
- Verifique se o arquivo `foto.jpg` existe na pasta raiz
- Confirme se a imagem não está corrompida

### "Erro ao carregar o classificador Haar Cascade"
- Verifique se o arquivo `haarcascade_frontalface_default.xml` está presente
- Reexecute o download do arquivo se necessário

### Problemas de compilação
- Confirme que está usando Java 11+
- Execute `mvn clean compile` para limpar e recompilar

## 📈 Melhorias Futuras

- [ ] Suporte para múltiplos formatos de imagem
- [ ] Interface gráfica
- [ ] Detecção em tempo real via webcam
- [ ] Configuração de parâmetros via arquivo
- [ ] Suporte para detecção de outros objetos

## 📄 Licença

Este projeto é de código aberto e está disponível sob a licença MIT.

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para:
- Reportar bugs
- Sugerir melhorias
- Enviar pull requests

---

**Desenvolvido com ❤️ usando Java e OpenCV**