import PIL
from PIL import Image
import glob

txtfiles = []
for file in glob.glob("*.png"):
    txtfiles.append(file)
for file in txtfiles:
    print(file)
    img = Image.open(file)    
    img = img.resize((73,97), PIL.Image.ANTIALIAS)
    img.save(file)
    

# print (" "+str(img.size[0])+" e "+str(img.size[1]))