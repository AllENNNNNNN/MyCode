using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Net;
using System.Web;

namespace WebServiceTest
{
    class Program
    {
        static void Main(string[] args)
        {

            //以Get方式调用
            HttpWebRequest request = WebRequest.Create("http://localhost:8080/wildfly-helloworld-rs/rest/get/007") as HttpWebRequest;
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                Console.WriteLine(reader.ReadToEnd());
            }

            //以Post方式调用

            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/create");
            HttpWebRequest request1 = WebRequest.Create(address) as HttpWebRequest;
            request1.Method = "POST";
            request1.ContentType = "application/x-www-form-urlencoded";

            String id = "456";
            String name = "test";
            StringBuilder data = new StringBuilder();
            //调用HttpUtility需要在.net 4.0框架下，并且添加System.web.dll引用，请自行谷歌
            data.Append("id=" + System.Web.HttpUtility.UrlEncode(id));
            data.Append("&name=" + System.Web.HttpUtility.UrlEncode(name));
            byte[] byteData = UTF8Encoding.UTF8.GetBytes(data.ToString());
            request1.ContentLength = byteData.Length;
            using (Stream postStream = request1.GetRequestStream())
            {
                postStream.Write(byteData, 0, byteData.Length);
            }

            using (HttpWebResponse response1 = request1.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response1.GetResponseStream());
                Console.WriteLine(reader.ReadToEnd());
            }


        }
    }
}
