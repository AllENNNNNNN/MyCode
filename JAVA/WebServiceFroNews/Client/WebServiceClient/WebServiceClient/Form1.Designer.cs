namespace WebServiceClient
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.showBox = new System.Windows.Forms.TextBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.updateTitleTextBox = new System.Windows.Forms.TextBox();
            this.updateContentTextBox = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.updateButton = new System.Windows.Forms.Button();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.label3 = new System.Windows.Forms.Label();
            this.deleteTitleTextBox = new System.Windows.Forms.TextBox();
            this.deleteButton = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.createTitleTextBox = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.createContentTextBox = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.keyWordTextBox = new System.Windows.Forms.TextBox();
            this.selectButton = new System.Windows.Forms.Button();
            this.createButton = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox5.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(511, 35);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "查找全部";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.showBox);
            this.groupBox1.Location = new System.Drawing.Point(24, 267);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(595, 270);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "结果显示区";
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // showBox
            // 
            this.showBox.Location = new System.Drawing.Point(0, 20);
            this.showBox.Multiline = true;
            this.showBox.Name = "showBox";
            this.showBox.Size = new System.Drawing.Size(589, 244);
            this.showBox.TabIndex = 0;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.updateButton);
            this.groupBox2.Controls.Add(this.textBox1);
            this.groupBox2.Controls.Add(this.updateContentTextBox);
            this.groupBox2.Controls.Add(this.updateTitleTextBox);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Location = new System.Drawing.Point(24, 180);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(595, 64);
            this.groupBox2.TabIndex = 2;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "更新区";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 37);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "Title:";
            // 
            // updateTitleTextBox
            // 
            this.updateTitleTextBox.Location = new System.Drawing.Point(54, 37);
            this.updateTitleTextBox.Name = "updateTitleTextBox";
            this.updateTitleTextBox.Size = new System.Drawing.Size(100, 21);
            this.updateTitleTextBox.TabIndex = 1;
            // 
            // updateContentTextBox
            // 
            this.updateContentTextBox.AutoSize = true;
            this.updateContentTextBox.Location = new System.Drawing.Point(178, 37);
            this.updateContentTextBox.Name = "updateContentTextBox";
            this.updateContentTextBox.Size = new System.Drawing.Size(47, 12);
            this.updateContentTextBox.TabIndex = 2;
            this.updateContentTextBox.Text = "Content";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(235, 37);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 21);
            this.textBox1.TabIndex = 3;
            // 
            // updateButton
            // 
            this.updateButton.Location = new System.Drawing.Point(487, 37);
            this.updateButton.Name = "updateButton";
            this.updateButton.Size = new System.Drawing.Size(75, 23);
            this.updateButton.TabIndex = 4;
            this.updateButton.Text = "更新";
            this.updateButton.UseVisualStyleBackColor = true;
            this.updateButton.Click += new System.EventHandler(this.updateButton_Click);
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.deleteButton);
            this.groupBox3.Controls.Add(this.deleteTitleTextBox);
            this.groupBox3.Controls.Add(this.label3);
            this.groupBox3.Location = new System.Drawing.Point(24, 116);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(595, 58);
            this.groupBox3.TabIndex = 3;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "删除区";
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.createButton);
            this.groupBox4.Controls.Add(this.createContentTextBox);
            this.groupBox4.Controls.Add(this.label5);
            this.groupBox4.Controls.Add(this.createTitleTextBox);
            this.groupBox4.Controls.Add(this.label4);
            this.groupBox4.Location = new System.Drawing.Point(24, 61);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(595, 49);
            this.groupBox4.TabIndex = 4;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "添加区";
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.selectButton);
            this.groupBox5.Controls.Add(this.keyWordTextBox);
            this.groupBox5.Controls.Add(this.label6);
            this.groupBox5.Location = new System.Drawing.Point(24, 13);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(481, 45);
            this.groupBox5.TabIndex = 5;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "查找区";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(8, 40);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 12);
            this.label3.TabIndex = 0;
            this.label3.Text = "Title:";
            // 
            // deleteTitleTextBox
            // 
            this.deleteTitleTextBox.Location = new System.Drawing.Point(55, 31);
            this.deleteTitleTextBox.Name = "deleteTitleTextBox";
            this.deleteTitleTextBox.Size = new System.Drawing.Size(100, 21);
            this.deleteTitleTextBox.TabIndex = 1;
            // 
            // deleteButton
            // 
            this.deleteButton.Location = new System.Drawing.Point(487, 20);
            this.deleteButton.Name = "deleteButton";
            this.deleteButton.Size = new System.Drawing.Size(75, 23);
            this.deleteButton.TabIndex = 2;
            this.deleteButton.Text = "删除";
            this.deleteButton.UseVisualStyleBackColor = true;
            this.deleteButton.Click += new System.EventHandler(this.deleteButton_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(10, 21);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 12);
            this.label4.TabIndex = 0;
            this.label4.Text = "Title:";
            // 
            // createTitleTextBox
            // 
            this.createTitleTextBox.Location = new System.Drawing.Point(54, 18);
            this.createTitleTextBox.Name = "createTitleTextBox";
            this.createTitleTextBox.Size = new System.Drawing.Size(100, 21);
            this.createTitleTextBox.TabIndex = 1;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(180, 21);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(47, 12);
            this.label5.TabIndex = 2;
            this.label5.Text = "Content";
            // 
            // createContentTextBox
            // 
            this.createContentTextBox.Location = new System.Drawing.Point(233, 18);
            this.createContentTextBox.Name = "createContentTextBox";
            this.createContentTextBox.Size = new System.Drawing.Size(100, 21);
            this.createContentTextBox.TabIndex = 3;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(12, 21);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(47, 12);
            this.label6.TabIndex = 0;
            this.label6.Text = "KeyWord";
            // 
            // keyWordTextBox
            // 
            this.keyWordTextBox.Location = new System.Drawing.Point(82, 18);
            this.keyWordTextBox.Name = "keyWordTextBox";
            this.keyWordTextBox.Size = new System.Drawing.Size(100, 21);
            this.keyWordTextBox.TabIndex = 1;
            // 
            // selectButton
            // 
            this.selectButton.Location = new System.Drawing.Point(342, 16);
            this.selectButton.Name = "selectButton";
            this.selectButton.Size = new System.Drawing.Size(75, 23);
            this.selectButton.TabIndex = 2;
            this.selectButton.Text = "查找";
            this.selectButton.UseVisualStyleBackColor = true;
            this.selectButton.Click += new System.EventHandler(this.selectButton_Click);
            // 
            // createButton
            // 
            this.createButton.Location = new System.Drawing.Point(487, 10);
            this.createButton.Name = "createButton";
            this.createButton.Size = new System.Drawing.Size(75, 23);
            this.createButton.TabIndex = 4;
            this.createButton.Text = "添加";
            this.createButton.UseVisualStyleBackColor = true;
            this.createButton.Click += new System.EventHandler(this.createButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(654, 594);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.groupBox5.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox showBox;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button updateButton;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label updateContentTextBox;
        private System.Windows.Forms.TextBox updateTitleTextBox;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button deleteButton;
        private System.Windows.Forms.TextBox deleteTitleTextBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.TextBox createContentTextBox;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox createTitleTextBox;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.Button selectButton;
        private System.Windows.Forms.TextBox keyWordTextBox;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button createButton;
    }
}

