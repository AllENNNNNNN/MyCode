using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using System.Net;
using System.IO;
namespace WebServiceClient
{
    class ServiceHandler
    {
        public string getAll()
        {
            string result = "";
            HttpWebRequest request = WebRequest.Create("http://localhost:8080/wildfly-helloworld-rs/rest/getAll") as HttpWebRequest;
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                string temp = "";
                while ((temp = reader.ReadLine()) != null)
                {
                    
                  //  Console.WriteLine(temp);
                    result += temp +"\r\n";
                }
               
            }
            Console.WriteLine(result);

            return result;
        }

        public string select(string title,string content)
        {
            string result = "";
            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/select/"+title);

            HttpWebRequest request = WebRequest.Create(address) as HttpWebRequest;
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                string temp = "";
                while ((temp = reader.ReadLine()) != null)
                    result += temp+"\r\n";
            }
            return result;
        }

        public string delete(string title)
        {
            
            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/delete/"+title);
            string result = "";
            HttpWebRequest request = WebRequest.Create(address) as HttpWebRequest;
            request.Method = "DELETE";
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                result += reader.ReadToEnd();
            }
            return result;
        }

        public string update(string title,string content)
        {
            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/update");
            string result = "";
            HttpWebRequest request = WebRequest.Create(address) as HttpWebRequest;
            request.Method = "PUT";
            request.ContentType = "application/x-www-form-urlencoded";
            StringBuilder data = new StringBuilder();
            data.Append("title=" + System.Web.HttpUtility.UrlEncode(title));
            data.Append("&content=" + System.Web.HttpUtility.UrlEncode(content));
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
                result += reader.ReadToEnd();
            }
            return result;
        }

        public string create(string title, string content)
        {
            Uri address = new Uri("http://localhost:8080/wildfly-helloworld-rs/rest/create");
            string result = "";
            HttpWebRequest request = WebRequest.Create(address) as HttpWebRequest;
            request.Method = "POST";
            request.ContentType = "application/x-www-form-urlencoded";
            StringBuilder data = new StringBuilder();
            data.Append("title=" + System.Web.HttpUtility.UrlEncode(title));
            data.Append("&content=" + System.Web.HttpUtility.UrlEncode(content));
            byte[] byteData = UTF8Encoding.UTF8.GetBytes(data.ToString());
                Console.WriteLine(data);
            request.ContentLength = byteData.Length;
            using (Stream postStream = request.GetRequestStream())
            {
                postStream.Write(byteData, 0, byteData.Length);
            }
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                result += reader.ReadToEnd();
            }
            return result;
        }
    }
}
