
from tkinter import messagebox
import cv2
from tkinter.filedialog import askopenfilename
import numpy as np
from PIL import Image, ImageDraw, ImageFont
from PIL import ImageFilter
import random
from tkinter import *

xx, yy = 0, 0

class imageClass:
    def __init__(self,nameWindow):
        self.__nameWindow = nameWindow
        self.__img = ""
        self.__file_name = ""

    def setfilename(self, filename):
        self.__file_name = filename

    def getfilename(self):
        return self.__file_name

    file_name = property(getfilename, setfilename)

    def setnameWindow(self, nameWindow):
        self.__nameWindow = nameWindow

    def getnameWindow(self):
        return self.__nameWindow

    nameWindow = property(getnameWindow, setnameWindow)

    def setimg(self, img):
        self.__img = img

    def getimg(self):
        return self.__img

    img = property(getimg, setimg)
    # @property צורה שניה
    # def __file_name(self):
    #     return self.__file_name
    #
    # @__file_name.setter
    # def __file_name(self, filename):
    #     self.__file_name = filename
    #
    #
    #
    # @property
    # def __nameWindow(self):
    #     return self.__nameWindow
    #
    #
    # @__nameWindow.setter
    # def __nameWindow(self, nameWindow):
    #     self.__nameWindow = nameWindow
    #
    # @property
    # def __img(self):
    #     return self.__img
    #
    #
    # @__img.setter
    # def __img(self, img):
    #     self.__img = img

    def add(self,event):
        self.file_name = askopenfilename(initialdir="C:\\images", title="chooseImage")
        self.nameWindow = "image"
        self.image = cv2.imread(self.file_name)
        self.image = cv2.resize(self.image, (600, 600))
        cv2.imshow(self.nameWindow, self.image)

    def black(self,event):
        self.image = cv2.cvtColor(self.image, cv2.COLOR_BGR2GRAY)
        cv2.imshow(self.nameWindow, self.image)

    def color(self,event):
        self.image = cv2.cvtColor(self.image, cv2.COLOR_BGR2YUV)
        cv2.imshow(self.nameWindow, self.image)

    def color1(self,event):
        self.image = cv2.cvtColor(self.image, cv2.AKAZE_DESCRIPTOR_MLDB_UPRIGHT)
        cv2.imshow(self.nameWindow, self.image)

    def imgCanny(self,event):
        imgCanny = cv2.Canny(self.image, 100, 200)
        kernel = np.ones((2, 2), np.uint8)
        self.image = cv2.dilate(imgCanny, kernel, iterations=3)
        cv2.imshow(self.nameWindow, self.image)

    def circle(self,event):
        self.image=cv2.resizeWindow(20,25)
        cv2.imshow(self.nameWindow, self.image)

    def blur(self,event):
        self.image = cv2.GaussianBlur(self.image, (7, 7), 0)
        cv2.imshow(self.nameWindow, self.image)

    def psifas(self,event):
        self.image=self.image.rotate(90)
        cv2.imshow(self.nameWindow, self.image)

    def bb(self,event):
        img = np.zeros((512, 512, 3), np.uint8)
        img = cv2.line(img, (0, 0), (511, 511), (255, 0, 0), 5)

    def draw_rect(self, event, x, y, flags, param):
        global ix, iy, jx, jy
        if event == cv2.EVENT_LBUTTONDOWN:
            ix = x
            iy = y
        elif event == cv2.EVENT_LBUTTONUP:
            jx = x
            jy = y
            cv2.rectangle(self.image, (ix, iy), (jx, jy), (50, 50, 50), 3)
            cv2.imshow(self.nameWindow, self.image)

    def draw_rect1(self, event, x, y, flags, param):
        global ix, iy, jx, jy
        if event == cv2.EVENT_LBUTTONDOWN:
            ix = x
            iy = y
        elif event == cv2.EVENT_LBUTTONUP:
            jx = x
            jy = y
            cv2.circle(self.image,(ix,iy),30,(50, 50, 50),-1)
            cv2.imshow(self.nameWindow, self.image)

    def drawCircle(self, event):
        cv2.setMouseCallback(self.nameWindow, self.draw_rect1)
        cv2.imshow(self.nameWindow, self.image)

    def drawsquare(self, event):
        cv2.setMouseCallback(self.nameWindow, self.draw_rect)
        cv2.imshow(self.nameWindow, self.image)

    def psifas(self, event):
        cv2.imshow(self.nameWindow, self.image)
        k = cv2.waitKey(0)
        if k == 27:
            cv2.destroyAllWindows()
        elif k == ord('s'):
            cv2.imwrite('messigray.png', self.image)
            cv2.destroyAllWindows()

    def addText(self, event, x, y, flags, param):
        global xx, yy
        if event == cv2.EVENT_LBUTTONDOWN:
            xx, yy = x, y

    def text(self, text):
        global xx, yy
        cv2.setMouseCallback(self.nameWindow, self.addText)
        cv2.putText(self.image, str(text.get()), (xx+300, yy+300), cv2.FONT_HERSHEY_COMPLEX_SMALL, 7, (50, 50, 50), 6)
        cv2.imshow(self.nameWindow, self.image)

    def pictureCutting(self,event):
        if self.t1.get() and self.t2.get():
            num1 = int(self.t1.get())
            num2 = int(self.t2.get())
            img = self.img[num1:num2]
            cv2.imshow(self.nameWindow, img)

    def save(self, text):
        cv2.imwrite(text + ".jpg", self.image)
        messagebox.showinfo('Message', 'The image has been saved as:'+text)

    def cutImage1(self, event, x, y, flags, param):
        global ix, iy, jx, jy, c
        if event == cv2.EVENT_LBUTTONDOWN:
            ix, iy, jx, jy = x, y, x, y
            c = True
        elif event == cv2.EVENT_LBUTTONUP:
            jx, jy = x, y
            c = False
            imgcut = self.image[ix:jx, iy:jy]
            cv2.imshow("aaa", imgcut)

    def cutImage(self, event):
        cv2.setMouseCallback(self.nameWindow, self.cutImage1)