#pypi에서 사용자들이 만든 패키지를 사용할 수 있다.

from requests import get 
#웹사이트에서 가져올 수 있는 get

#반복문
# for variable in Object(리스트,튜플등)

websites = [
    "google.com",
    "airbnb.com",
    "twitter.com",
    "facebook.com",
    "https://facebook.com"
]

results = {}

for i in range(len(websites)):
    if not websites[i].startswith("https://"):
        websites[i] = f"https://{websites[i]}"
    response = get(websites[i])
    if response.status_code == 200:
        results[websites[i]] = "OK"
    else:
        results[websites[i]] = "FAILED"
        
#200은 정상적으로 요청에 응답했음을 알려준다.

print(results)

    

