using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.IO;

namespace SPOJBackUp
{
    public partial class Form1 : Form
    {


        public Form1()
        {
            InitializeComponent();
            textBox2.PasswordChar = '*';
        }

        static bool Login(String username, String Password, ref CookieContainer cookie)
        {

            CookieContainer myCookies = cookie;

            //string mySrc = HTTPMethods.GET("https://www.spoj.com/login", "https://www.spoj.com/login", myCookies);

            String user = username;

            String pass = Password;

            String postData = "login_user=" + user + "&password=" + pass + "&next_raw=%2F";
            bool mySrc = HTTPMethods.POST("https://www.spoj.com/login", postData, "https://www.spoj.com/login", ref myCookies);

            if (mySrc)
            {


                return true;
            }
            else
            {


                return false;

            }

        }
        static void DownloadByURL()
        {

            Console.Write("Url: "); string remoteUri = Console.ReadLine();
            Console.Write("FileName: "); string fileName = Console.ReadLine(), myStringWebResource = null;
            WebClient myWebClient = new WebClient();
            myStringWebResource = remoteUri + fileName;
            Console.WriteLine("Downloading File \"{0}\" from \"{1}\" .......\n\n", fileName, myStringWebResource);
            myWebClient.DownloadFile(myStringWebResource, fileName);
            Console.WriteLine("Successfully Downloaded File \"{0}\" from \"{1}\"", fileName, myStringWebResource);
            Console.WriteLine("\nDownloaded file saved in the following file system folder:\n\t" + AppDomain.CurrentDomain.BaseDirectory);

        }

        static void DownloadByRequest(String NameOfProblem, CookieContainer cookie)
        {

            String name = NameOfProblem;
            String url = "https://www.spoj.com/problems/" + name + "/edit2/";
            String referer = "https://www.spoj.com/problems/" + name + "/edit2";
            String postData2 = "export%5Ball%5D=on&form_action=export";
            HttpWebRequest webReq = (HttpWebRequest)WebRequest.Create(url);
            webReq.Method = "POST";
            webReq.CookieContainer = cookie;
            webReq.UserAgent = "";
            webReq.Referer = referer;
            webReq.ContentType = "application/x-www-form-urlencoded";
            webReq.Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
            Stream postStream = webReq.GetRequestStream();
            byte[] postByte = Encoding.ASCII.GetBytes(postData2);
            postStream.Write(postByte, 0, postByte.Length);
            postStream.Dispose();
            HttpWebResponse webResp = (HttpWebResponse)webReq.GetResponse();

            using (Stream output = File.OpenWrite(name + ".zip"))
            using (Stream input = webResp.GetResponseStream())
            {
                input.CopyTo(output);
            }
        }

        

        private void button1_Click(object sender, EventArgs e)
        {
            String user = textBox1.Text;
            String pass = textBox2.Text;

            //Create CookieContainer
            CookieContainer myCookies = new CookieContainer();

            //Login
            Boolean checkLogin = Login(user, pass, ref myCookies);
            if (!checkLogin)
            {
                MessageBox.Show("Failed Login");
                return;
            }

            MessageBox.Show("Successful Login");



            //GetHeaderOfSpojPage
            string mySrc2 = HTTPMethods.GET("https://www.spoj.com/problems/my/", "https://www.spoj.com/problems/my/", myCookies);


            //LoadHtml
            HtmlAgilityPack.HtmlDocument htmlDoc = new HtmlAgilityPack.HtmlDocument();
            htmlDoc.LoadHtml(mySrc2);

            //GetListPage
            List<String> pageList = new List<string>();
            List<int> startPage = new List<int>();

            foreach (var node in htmlDoc.DocumentNode.SelectNodes("//center/ul[@class='pagination']/li"))
            {

                if (node.SelectSingleNode(".//a[@class='pager_link']") != null)
                {
                    String page = node.SelectSingleNode(".//a[@class='pager_link']").InnerText;
                    pageList.Add(page);
                }


            }


            int count = 0;
            for (int index = 0; index < pageList.Count - 1; index++)
            {
                startPage.Add(count);
                count = count + 50;

            }




            //Download
            for (int index = 0; index < startPage.Count; index++)
            {

                string downloadUrl = "https://www.spoj.com/problems/my/sort=0,start=" + startPage[index];
                string mySrc3 = HTTPMethods.GET(downloadUrl, downloadUrl, myCookies);
                HtmlAgilityPack.HtmlDocument htmlDoc2 = new HtmlAgilityPack.HtmlDocument();
                htmlDoc.LoadHtml(mySrc3);
                List<String> listName = new List<String>();
                foreach (var node in htmlDoc.DocumentNode.SelectNodes("//table[@class='problems table table-condensed']/tr[@class='problemrow_']"))
                {
                    if (node.SelectSingleNode(".//a[@title='Submit a solution to this problem.']") != null)
                    {
                        String nameTemp = node.SelectSingleNode(".//a[@title='Submit a solution to this problem.']").InnerText;
                        listName.Add(nameTemp);
                    }
                }

                for (int i = 0; i < listName.Count; i++)
                {
                    String tempValue = listName[i];
                    string nameOfProblem = tempValue.Remove(0, 1);
                    ListViewItem item = new ListViewItem(nameOfProblem);
                    item.SubItems.Add("Downloaded");
                    item.SubItems.Add(AppDomain.CurrentDomain.BaseDirectory);
                    listView1.Items.Add(item);
                    DownloadByRequest(nameOfProblem, myCookies);

                }


            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
