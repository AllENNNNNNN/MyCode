using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WebServiceClient
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Console.WriteLine(new ServiceHandler().getAll());
            this.showBox.Text = new ServiceHandler().getAll();
        }

        private void selectButton_Click(object sender, EventArgs e)
        {
            string title = this.keyWordTextBox.Text;
            string content = title;
            this.showBox.Text = new ServiceHandler().select(title,content);
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {
            string title = this.deleteTitleTextBox.Text;
            this.showBox.Text = new ServiceHandler().delete(title) + "\r\n\r\n\r\n" + new ServiceHandler().getAll();
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            string title = this.updateTitleTextBox.Text;
            string content = this.updateContentTextBox.Text;
            this.showBox.Text = new ServiceHandler().update(title, content) + "\r\n\r\n\r\n" + new ServiceHandler().getAll();
        }

        private void createButton_Click(object sender, EventArgs e)
        {
            string title = this.createTitleTextBox.Text;
            string content = this.createContentTextBox.Text;
            this.showBox.Text = new ServiceHandler().create(title, content) + "\r\n\r\n\r\n" + new ServiceHandler().getAll();
        }
    }
}
