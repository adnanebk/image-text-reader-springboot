# image-text-reader-springboot

this is a rest application to extract text from pdf documents by using Tesseract, an optical character recognition (OCR) engine, 

Tesseract OCR needs tessdata files to set the language to the OCR process

so download them  from here https://github.com/tesseract-ocr/tessdata 
and put them in C drive inside a folder named tessdata as the path in application.properties describes
{tesseract.path = C://tessdata}
