#import imageClass
from tkinter import *
import tkinter as tk
import numpy as np
from PIL import Image
from tkinter import filedialog
import cv2
import imageClass

def close(self):
    x.quit()


class windowClass:
    def __init__(self, win):
        self.image = imageClass.imageClass(win)
        self.t1= Entry(win)
        self.t2 = Entry(win)

        self.btn1 = Button(win,text="הוסף תמונה", bg="#D70303",font=('calibri', 15, 'bold'))
        self.btn2 = Button(win,text="    אפור  " , bg="silver")
        self.btn3 = Button(win,text="גוונים זוהרים" , bg="silver")
        self.btn4 = Button(win,text=" שחור לבן" , bg="silver")
        self.btn5 = Button(win,text="חיתוך תמונה ", bg="silver")
        self.btn6 = Button(win,text="     טשטוש     "  , bg="silver")
        self.btn7 = Button(win,text=" גווני פסטל  " , bg="silver")
        self.btn9 = Button(win, text="יציאה", bg="#D70303",font=('calibri', 15, 'bold'))
        self.btn10 = Button(win, text='   שמירת תמונה   ', bd="4", bg="silver",
                           command=lambda: self.image.save(self.t2.get()))
        self.btn11 = Button(win, text="  הוספת טקסט   ", bd="4", bg="silver", command=lambda: self.image.text(self.t1))
        self.btn12 = Button(win, text="צייר עיגול", bg="silver")
        self.btn13 = Button(win, text="צייר ריבוע", bg="silver")
        self.lbl1 = Label(win, text='הכנס טקסט:')
        self.lbl2 = Label(win, text='Image Processing', bd="4", bg="#D70303", font=('calibri', 20, 'bold', 'underline'))
        self.positions()
        self.events()

    def positions(self):
        self.btn1.place(x=480, y=30)  # הוסף תמונה
        self.lbl2.place(x=190, y=30)
        self.btn9.place(x=40, y=30)  # יציאה

        self.btn2.place(x=420, y=170)  # אפור
        self.btn4.place(x=420, y=240)  # שחור לבן


        self.btn12.place(x=280, y=170)  # צייר עיגול
        self.btn13.place(x=280, y=240)  # צייר ריבוע

        self.btn7.place(x=120, y=170)  # פסטל
        self.btn3.place(x=120, y=240)  # גוונים זוהרים

        self.btn5.place(x=400, y=380)  # חיתוך
        self.btn6.place(x=400, y=450)  # טשטוש

        self.btn11.place(x=200, y=380)  # הוספת טקסט
        self.t1.place(x=50, y=380)
        self.btn10.place(x=200, y=450)  # שמירה
        self.t2.place(x=50, y=450)

    def events(self):
        self.btn1.bind('<Button-1>', self.image.add)
        self.btn2.bind('<Button-1>', self.image.black)
        self.btn3.bind('<Button-1>', self.image.color)
        self.btn4.bind('<Button-1>', self.image.imgCanny)
        self.btn11.bind('<Button-1>', self.image.drawsquare)
        self.btn12.bind('<Button-1>', self.image.drawCircle)
        self.btn13.bind('<Button-1>', self.image.drawsquare)
        self.btn5.bind('<Button-1>', self.image.cutImage)
        self.btn6.bind('<Button-1>', self.image.blur)
        self.btn7.bind('<Button-1>', self.image.color1)
        self.btn9.bind('<Button-1>',close)



x = Tk()
mywin = windowClass(x)
x.title("ProjectImage")
x.geometry("600x600+700+40")
x.configure(bg='#BFE7E5')
x.mainloop()