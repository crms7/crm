var air_cookie={
    set: function(name, value, day, domain, path, secure) {
        let cookieText = "",date=Number(day);
        cookieText += `${encodeURIComponent(name)}=${encodeURIComponent(value)}`;
        if (!isNaN(date)&&date!=Infinity) {
            cookieText += `; day=${new Date(new Date().getTime()+date*86400000)}`
        }
        if (path) {
            cookieText += `; path=${path}`;
        }
        if (domain) {
            cookieText += `; domain=${domain}`;
        }
        if (secure) {
            cookieText += "; secure";
        }
         document.cookie = cookieText;
    },
    get: function(name) {
        let cookieName = `${encodeURIComponent(name)}=`,
            cookieStart = document.cookie.indexOf(cookieName),
            cookieValue = "";
        if (cookieStart > -1) {
            let cookieEnd = document.cookie.indexOf(";", cookieStart);
            if (cookieEnd == -1) {
                cookieEnd = document.cookie.length;
            }
            cookieValue = decodeURIComponent(document.cookie.substring(cookieStart + cookieName.length, cookieEnd));
        }
        return cookieValue;
    },
    del: function(name) {
        if(Array.isArray(name)){
            name.forEach(val=>this.set(val, "", new Date(0)))
        }else{
        this.set(name, "", new Date(0));
        }
    }
}
