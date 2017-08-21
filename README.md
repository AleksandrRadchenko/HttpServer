# EPAM Labs Teams - HTTP Server project
[ ![Codeship Status for Alsturm/JavaSchool](https://app.codeship.com/projects/534a42a0-68da-0135-a2fd-7252115b1a9b/status?branch=master)](https://app.codeship.com/projects/227204)

21.08.2017 - Functionality at the moment of sharing code to the EPAM Labs working group:

многопоточность на Executors.newCachedThreadPool()
принимает только GET и HEAD
отдает файл с именем из запроса, или index.html, если запрос вида /
плюется ошибками 400, если запрос неправильный, и 404, если не находит файл
пишет в лог, ошибки и инфо
определяет MIME type файла, который отдает, и прописывает его в HTTP ответе
