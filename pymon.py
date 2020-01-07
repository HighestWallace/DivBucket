import pymongo
import pandas as pd
import numpy as np
from flask import Flask
from flask import jsonify
from flask import request

#
app = Flask(__name__, static_url_path='/static')
app.config['JSON_AS_ASCII'] = False

tran_web_tag ={
    "代码":0,
    "娱乐":1,
    "科技":2,
    "艺术":3,
    "生活":4,
    "游戏":5,
    "影视":6
}

tran_work_tag ={
    "student":0,
    "teacher":1,
    "programmer":2,
    "pm":3,
    "engineer":4,
    "businessman":5,
    "anchor":6
}

web_tag = []
user_tag = {}
user_web = []

myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["test"]
web = mydb["web_monitor"]

for x in web.find():
    #user_web.append([x["user_id"],x["url"]])
    for i in x["tag"]:
        web_tag.append([x["user_id"], x["url"], tran_web_tag[i]])
#print (user_web)
print (web_tag)

user = mydb["user"]
for x in user.find():
    #y.append(x)    
    #user_tag.append([x["user_id"], tran_web_tag[i]])
    user_tag.update({x["user_id"]:tran_web_tag[i]})
#print (user_tag)    

for i in web_tag:
    i[0] = user_tag[i[0]]
print (web_tag)

def InitStat_update(records):
    user_tags = dict()  # 用户打过标签的次数
    tag_items = dict()  # 网站被打过标签的次数，代表网站热度
    tag_user = dict()   # 标签被用户标记次数
    
    for user, item, tag in records:
        user_tags.setdefault(user, dict())
        user_tags[user].setdefault(tag, 0)
        user_tags[user][tag] += 1

        tag_items.setdefault(tag, dict())
        tag_items[tag].setdefault(item, 0)
        tag_items[tag][item] += 1
        
        tag_user.setdefault(tag, dict())
        tag_user[tag].setdefault(user, 0)
        tag_user[tag][user] += 1
            
    print("用户打过标签的次数: ", user_tags)
    print("网站打过标签的次数: ", tag_items)
    print("标签被用户使用次数: ", tag_user)
    
    return user_tags, tag_items, tag_user

(user_tags, tag_items, tag_user) = InitStat_update(web_tag)
print (InitStat_update(web_tag))

def Recommend(user, K):
    recommend_items = dict()
    for tag, wut in user_tags[user].items():
        for item, wti in tag_items[tag].items():
            if item not in recommend_items:
                recommend_items[item] = wut * wti    # 计算用户对网站兴趣度
            else:
                recommend_items[item] += wut * wti

    rec = sorted(recommend_items.items(),key = lambda x:x[1],reverse = True)   # 将推荐网站按兴趣度排名
    print("用户对网站兴趣度: ", rec)
    # recommend_web = ()
    # for i in range(K):
    #     recommend_web.append(rec[i][0])
    #recommend_web = "/".join(recommend_web)
    recommend_web = rec[0][0]
    print("为用户推荐网站: ", recommend_web)
    return recommend_web



@app.route('/user/recommend', methods =['GET', 'POST'])
def rec():
    work = request.get_json() ['user_id']
    if isinstance(work,str):
        return Recommend(tran_work_tag[work],1)
    return Recommend(work, 1)

#print( Recommend(1, 1))
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000)