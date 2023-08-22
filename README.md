Browser Stack integration steps

Sample request for uploading the App with custom ID
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@C:\Users\_VOIS\Documents\Mobile Applications\Android\General-Store.apk" -F "custom_id=GeneralStoreApp"
Sample response
{"app_url":"bs://7ec02e201cc6ef4c3971f75266a7a722188ecdc1","custom_id":"GeneralStoreApp","shareable_id":"ahmedmadyan_oxTGNa/GeneralStoreApp"}

Sample request for deleting the App
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X DELETE "https://api-cloud.browserstack.com/app-automate/app/delete/1824c7990fe34023bdd4e19715f15873e71ea265"

Browser stack plan
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" https://api.browserstack.com/automate/plan.json

Browser stack available browsers and devices
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" https://api.browserstack.com/automate/browsers.json