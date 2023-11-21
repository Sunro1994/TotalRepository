#반복문
# for variable in Object(리스트,튜플등)

websites = [
    "google.com",
    "airbnb.com",
    "twitter.com",
    "facebook.com",
    "https://facebook.com"
]

for i in range(len(websites)):
    if not websites[i].startswith("https://"):
        websites[i] = f"https://{websites[i]}"

for website in websites:
    website = f"http:"
    print(website)
    
print(websites)

