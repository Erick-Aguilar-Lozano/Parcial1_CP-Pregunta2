using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace $safeprojectname$
{
    public partial class Form1 : Form
    {
        double a;
        double b;
        string c;
        public Form1()
        {
            InitializeComponent();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
            {
                textBox1.Text = ((Button)sender).Text; 
            }
            else
            {
                textBox1.Text = textBox1.Text + ((Button)sender).Text;
            }
        }
        private void Form1_Load(object sender, EventArgs e)
        {
        }
        private void button11_Click(object sender, EventArgs e)
        {
            a = Convert.ToDouble(this.textBox1.Text);
            c = ((Button)sender).Text;
            this.textBox1.Clear();
            this.textBox1.Focus();
        }
        private void button15_Click(object sender, EventArgs e)
        {
            b = Convert.ToDouble(this.textBox1.Text);
            switch (c)
            {
                case "+":
                    this.textBox1.Text = Convert.ToString(b + a);
                    break;
                case "-":
                    this.textBox1.Text = Convert.ToString(a - b);
                    break;
                case "*":
                    this.textBox1.Text = Convert.ToString(b * a);
                    break;
                case "/":
                    this.textBox1.Text = Convert.ToString(a / b);
                    break;
            }
        }
        private void button16_Click(object sender, EventArgs e)
        {
            this.textBox1.Text = "";
        }
      
    }
}
