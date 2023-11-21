import requests
from bs4 import BeautifulSoup
from selenium import webdriver;
import time
import random
import json
from openpyxl import workbook


def Crawling(keyword) : 
    headers = {'User-agent', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36'}
    response = requests.get('https://www.goodchoice.kr/product/result?sel_date=2023-11-02&sel_date2=2023-11-03&keyword='+f'{keyword}')
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')

    # driver = webdriver.Chrome()
    # driver.get('https://www.goodchoice.kr/product/result?keyword=%EC%84%9C%EC%9A%B8')
    # driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    # selHtml = driver.page_source
    # selSoup = BeautifulSoup(selHtml, 'html.parser')

    links = soup.select('.list_4 a')

    Lodge_results = []

    idx = 0
    Lodge_idx=200;
    count =0;
    for link in links :
    
        # 링크에서 링크로 만듬soup
        url = link.attrs['href']
        response2 = requests.get(url)
        details = BeautifulSoup(response2.text, 'html.parser')

        # 방 종류, 방 이미지, 방 가격, 방 개수
        roomTypes = details.select('.room .title')
        roomimgs = details.select('.pic_view img')

        i = 0
        
        i2=0
        room_results=[];
        
        
        
            
        idx = idx + 1
        Lodge_idx = Lodge_idx+1;
        prices =0;
        
        for roomType in roomTypes :
            roomType0 = roomTypes[i].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ').strip()
            roomimg = roomimgs[i]['data-original']

            prices= random.randint(5,10)*10000;
            room_count = random.randint(1,4);
            Lodge_Room_Type_MaxCapacity = random.randint(4,8);
            room_results.append({'roomType': roomType0, 'roomimg': roomimg, 'price' : prices})
            Lodge_results.append(
                {
                'Lodge_Roome_Price'    : prices,
                'Lodge_Room_Type_Name'     : room_results[i2]['roomType'],
                'Lodge_Room_Type_MinCapacity' : 2,
                'Lodge_Room_Type_MaxCapacity' : Lodge_Room_Type_MaxCapacity,
                'Lodge_Room_Type_Img' : room_results[i2]['roomimg'],
                'Lodge_Room_Type_Price' : room_results[i2]['price'],
                'Lodge_Room_Type_Count' : room_count,
                'Lodge_idx' : Lodge_idx,
                'count'     : i2,
                }
            )
            
            i = i + 1
            i2 +=1;
            count +=1;
        if(Lodge_idx ==240):
            break;
       

    return Lodge_results
keyword = '인천'

file = open(f'{keyword}객실정보.csv','w',encoding='utf-8')
file.write("Lodge_Roome_Price, Lodge_Room_Type_Name, Lodge_Room_Type_MinCapacity, Lodge_Room_Type_MaxCapacity, Lodge_Room_Type_Img, Lodge_Room_Type_Price,Lodge_idx,Lodge_Room_Type_Count\n")

yanolja = Crawling(keyword)
    

for data in yanolja:
    
    file.write(f"{data['Lodge_Roome_Price']},{data['Lodge_Room_Type_Name']},{data['Lodge_Room_Type_MinCapacity']},{data['Lodge_Room_Type_MaxCapacity']}, {data['Lodge_Room_Type_Img']},{data['Lodge_Room_Type_Price']},{data['Lodge_idx']},{data['Lodge_Room_Type_Count']}\n ")
    


file.close()