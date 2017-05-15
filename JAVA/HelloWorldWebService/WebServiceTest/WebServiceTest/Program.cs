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
            new Program().get();

            //以Post方式调用
            new Program().Post();

            //以Put方式调用
            new Program().put();

            //以Delete方式调用
            new Program().delete();

     

        }

        void get()
        {
            HttpWebRequest request = WebRequest.Create("http://localhost:8080/wildfly-helloworld-rs/rest/get/007") as HttpWebRequest;
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                Console.WriteLine(reader.ReadToEnd());
            }
        }

        void Post()
        {
            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/create");
            HttpWebRequest request1 = WebRequest.Create(address) as HttpWebRequest;
            request1.Method = "POST";
            request1.ContentType = "application/x-www-form-urlencoded";

            String id = "789";
            String name = "test";
            StringBuilder data = new StringBuilder();
            //调用HttpUtility需要在.net 4.0框架下，并且添加System.web.dll引用，请自行谷歌
            data.Append("id=" + System.Web.HttpUtility.UrlEncode(id));
            data.Append("&name=" + System.Web.HttpUtility.UrlEncode(name));
            byte[] byteData = UTF8Encoding.UTF8.GetBytes(data.ToString());
          //  Console.WriteLine(data);
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

        void put()
        {
            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/update");
            HttpWebRequest request = WebRequest.Create(address) as HttpWebRequest;
            request.Method = "PUT";
            request.ContentType = "application/x-www-form-urlencoded";
            String id = "789";
            String name = "test";
            StringBuilder data = new StringBuilder();
            data.Append("id=" + System.Web.HttpUtility.UrlEncode(id));
            data.Append("&name=" + System.Web.HttpUtility.UrlEncode(name));
            byte[] byteData = UTF8Encoding.UTF8.GetBytes(data.ToString());
       //     Console.WriteLine(data);
            request.ContentLength = byteData.Length;
            using (Stream putStream = request.GetRequestStream()) 
            {
                putStream.Write(byteData, 0, byteData.Length);
            }

            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                Console.WriteLine(reader.ReadToEnd());
            }
        }

        void delete()
        {

            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/delete/789");
            HttpWebRequest request = WebRequest.Create(address) as HttpWebRequest;
            request.Method = "DELETE";
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                Console.WriteLine(reader.ReadToEnd());
            }
        }


    }
}
