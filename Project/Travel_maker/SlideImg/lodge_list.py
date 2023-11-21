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
    xx=1;
    count =40;
    for link in links :
        
        # 링크에서 링크로 만듬soup
        url = link.attrs['href']
        response2 = requests.get(url)
        details = BeautifulSoup(response2.text, 'html.parser')

        # 모텔인지 호텔인지
        types = soup.select('.right_badges .badge .build_badge')
        type = types[idx].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ')

        # 숙소이름
        titles = details.select('h2')
        title = titles[0].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ').replace('"',' ').replace(' \' ',' ')

        #숙소 주소
        addrs = details.select('.address')
        addr = addrs[0].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ')

        #숙소 평점
        scores = details.select('.score_cnt span')
        score = 7
        if(scores):
            score = scores[0].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ')
            
        else:
            print(title)
        
        #리스트 이미지 이름
        imgs = details.select('.swiper-slide img')  
        img = imgs[0]['data-src']

        # 숙소 전화번호
        pNums = details.select('.seller_info ul:nth-child(8)')
        pNum = pNums[0].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ')
        
        # 사업자번호
        # bNums = details.select('.seller_info ul:nth-child(12)')
        # bNum = bNums[0].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ')

        # 숙소 내용
        contents = details.select('.default_info')
        content = contents[0].text.replace('\r', '').replace('\n', '').replace('-', '').replace(',',' ').replace('/',' ').replace('*',' ')

        # # 방 종류, 방 이미지, 방 가격, 방 개수
        roomTypes = details.select('.room .title')
        roomimgs = details.select('.pic_view img')
       

        i = 0
        
        i2=0
        
        Lodge_results.append(
            {
                'Lodge_name'     : title,
                'Lodge_address'   : addr,
                'Lodge_rate'     : score,
                'Lodge_type'      : type, 
                'Lodge_RealImgName'  : img,
                'Lodge_Tel'      : pNum,
                # 'bNum'      : bNum,
                'Lodge_content'   : content,
                
            }
        )
        count +=1;  
        idx = idx + 1
        if(count ==80):
            break
        
       

    return Lodge_results


# keyword_arr=['광주','울산','인천','강원도','경기도','경상남도','경상북도','전라남도','전라북도','충청남도','충청북도']
keyword = '충청북도'
# for keyword in keyword_arr:
file = open(f'{keyword}.csv','w',encoding='utf-8')
file.write("Lodge_name,Lodge_address,Lodge_rate,Lodge_type,Lodge_RealImgName,Lodge_Tel,Lodge_content,Lodge_SellerInfo_BusinessNum\n");
yanolja = Crawling(keyword)
x = 1;
for data in yanolja:
    file.write(f"{data['Lodge_name']},{data['Lodge_address']},{data['Lodge_rate']},{data['Lodge_type']},{data['Lodge_RealImgName']},{data['Lodge_Tel']},{data['Lodge_content']},{x}\n ")
    x+=1;
    if(x==11):
        x = x%10;
        

file.close()