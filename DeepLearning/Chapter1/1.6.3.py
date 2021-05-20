import matplotlib.pyplot as plt
from matplotlib.image import imread

img = imread('model.jpg') # 이미지 읽어오기 (적절한 경로 설정)

plt.imshow(img)
plt.show()