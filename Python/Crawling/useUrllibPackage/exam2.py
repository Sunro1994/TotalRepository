import urllib.request

res = urllib.request.urlopen("http://unico2013.dothome.co.kr/crawling/tagstyle.html")
print(res)
print("[header정보]-------")
res_header=res.getheaders()
for s in res_header:
    print(s)
print("[body 내용]------------")
# utf-8로 변환하지 않으면 16진수 코드를 반환한다.
# print(res.read())
print(res.read().decode('utf-8'))