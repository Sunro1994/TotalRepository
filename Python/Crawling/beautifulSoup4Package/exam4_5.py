#파일명 : exam4_5.py
html_doc="""
<!DOCTYPE html>
<html>
  <head>
     <meta charset='utf-8'>
     <title>Test BeautifulSoup</title>
  </head>
  <body>
     <p align="center"> text contents </p>
     <p align="right">  text contents 2 </p>
     <p align="left">   text contents 3 </p>
     <img src="http://unico2013.dothome.co.kr/image/flower.jpg" width="500">
     <div>
       <p>text contents 4</p> 
     </div>
  </body>
</html> """

from bs4 import BeautifulSoup
bs = BeautifulSoup(html_doc, 'html.parser')
print(type(bs.find('p')))
print(type(bs.find_all('p')))
print("---------------------------------")
print(bs.find('title'))
print(bs.find('p'))
print(bs.find('img'))
print("---------------------------------")
ptags = bs.find_all('p')
print(ptags)
print("----------------")
for tag in ptags :
    print(tag)

    
    
    
    
    
    
    
    