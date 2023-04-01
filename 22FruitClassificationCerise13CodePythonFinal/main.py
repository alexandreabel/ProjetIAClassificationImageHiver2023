#fait a partir de FruitClassificationTensorFlowMode forAndroidApp6  sur google colab

#entrainement pour detecter 13 objet soit si c une pomme, une cerise , une orange , un 7up, Alexandre Abel, du Nesquik au chocolat, du Nesquik au fraise, un chocolat Skor,une coffee crisp , de la sauce hot chicken ,du thon Rio mare ,de la moutarde ou du deodorant Axe

#fait avec le dataset de 20 000 image par element (28 640 en vrai

#test=5800 train=20 000 validation =2840)

#fait sur python 3.9


#modele 1
#Epoch 40/40
#550/550 [==============================] - 12s 22ms/step - loss: 0.0137 - accuracy: 0.9958 - val_loss: 0.6226 - val_accuracy: 0.8867
#160/160 [==============================] - 3s 15ms/step - loss: 0.4060 - accuracy: 0.9317

#modele 2
#Epoch 150/150
#550/550 [==============================] - 30s 54ms/step - loss: 4.8402e-04 - accuracy: 0.9997 - val_loss: 1.3992 - val_accuracy: 0.9315
#160/160 [==============================] - 3s 17ms/step - loss: 0.8825 - accuracy: 0.9589

#pip install tensorflow matplotlib
#!pip install tensorflow==2.9.0 tensorflow-gpu==2.9.0  matplotlib
#flatbuffers-1.12 keras-2.9.0 keras-preprocessing-1.1.2
# pip install flatbuffers==2.0 keras==2.11.0
#pip install tensorflow==2.10.1 tensorflow-gpu==2.10.1  matplotlib
# pip install _jit_compiled_convolution_op _update_step_xla

#pip install tensorflow==2.11.0 matplotlib keras==2.11.0
#cest lui qui marche

#pip install tensorflow==2.10.0 matplotlib keras==2.10.0
#pip install tensorflow==2.9.0 matplotlib keras==2.9.0
#pip install tensorflow==2.8.0 matplotlib keras==2.8.0
#pip install tensorflow==2.7.0 matplotlib keras==2.7.0
#pip install tensorflow==2.6.0 matplotlib keras==2.6.0

import numpy
import tensorflow as tf
import matplotlib.pyplot as plt
#from tensorflow.keras.layers import Input, Dense
#import keras

import numpy as np
import os
import PIL
import keras

#from tensorflow import keras
#from tensorflow.python import keras
#from tensorflow.contrib import keras
#from tensorflow.keras import layers   #vielle facon de faire
#from tensorflow.keras.models import Sequential  #vielle facon de faire

from keras import layers   #nouvelle facon de faire
from keras.models import Sequential  #nouvelle facon de faire
#from tensorflow.keras.layers import Conv2D, MaxPooling2D, Dense, Flatten, Dropout
#from tensorflow._api.v2.experimental import numpy

img_height, img_width = 64, 64   #il faut que les deux nombre soit egal pour faire des image carrer
                       #je crois que c la taille qui va mettre nos image pour lentrainement
                       #plus le nombre est gros plus sa  peut donner des modele precis mais c plus lourd a entrainer  (je crois a verifier si c vraiment sa)

batch_size = 20    # cest le nombre dimage quon va envoyer a notre modele en meme temps
                   #en gros pour optimiser le modele au lieux denvoyer une image a la fois on en envoir 20 dans cette exemple



train_ds = tf.keras.utils.image_dataset_from_directory(
    r"C:\Users\Abel\Desktop\fruitsPommeCeriseOrange6\train",
   # "fruitsPommeCeriseOrange/train",
    image_size = (img_height, img_width),
    batch_size = batch_size
)
#je coit quon peut ajouter aussi les methode prefaite
#data_dir     yer deja la dans lexemple le data directory c le  "/content/drive/MyDrive/fruitsPommeCeriseOrange3/train",
#validation_split  = 0.2,
#subset = "training",
#seed=42,
#en plus de ceux deja present comme dans lexemple image_size = (img_height, img_width),  et    batch_size = batch_size

val_ds = tf.keras.utils.image_dataset_from_directory(
    r"C:\Users\Abel\Desktop\fruitsPommeCeriseOrange6\validation",
   # "fruitsPommeCeriseOrange/validation",
    image_size = (img_height, img_width),
    batch_size = batch_size
)
test_ds = tf.keras.utils.image_dataset_from_directory(
    r"C:\Users\Abel\Desktop\fruitsPommeCeriseOrange6\test",
    #"fruitsPommeCeriseOrange/test",
    image_size = (img_height, img_width),
    batch_size = batch_size
)



class_names = ["7up","Alexandre Abel","Nesquik au chocolat", "Nesquik Au Fraise", "chocolat Skor","coffee Crisp","deodorant Axe","moutarde","oignon espagnol","orange","pomme","sauce Hot Chicken","thon Rio Mare"]
plt.figure(figsize=(10,10))
for images, labels in train_ds.take(1):
  for i in range(9):
    ax = plt.subplot(3, 3, i + 1)
    plt.imshow(images[i].numpy().astype("uint8"))
    plt.title(class_names[labels[i]])
    plt.axis("off")



num_classes = len(class_names)

model = tf.keras.Sequential(
    [
     tf.keras.layers.Rescaling(1./255),
     tf.keras.layers.Conv2D(32, 3, activation="relu"),
     tf.keras.layers.MaxPooling2D(),
     tf.keras.layers.Conv2D(32, 3, activation="relu"),
     tf.keras.layers.MaxPooling2D(),
     tf.keras.layers.Conv2D(32, 3, activation="relu"),
     tf.keras.layers.MaxPooling2D(),
     tf.keras.layers.Flatten(),
     tf.keras.layers.Dense(128, activation="relu"),
     tf.keras.layers.Dense(13) # je crois que ici le nombre reprersente le nombre de classe detectable anciennement cetait 3
                                 #sa peut donner une erreur lors de lentrainement si c pas le meme nombre de classe dans le layers.Dense qu'il y a réellement
    ]
)



model.compile(
    optimizer="adam",
    #loss=tf.losses.SparseCategoricalCrossentropy(from_logits = True),
    loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
    metrics=['accuracy']
)


epochs=150  #etait a 10
hist = model.fit(
    train_ds,
    validation_data = val_ds,
    epochs=epochs
)




acc = hist.history['accuracy']
val_acc = hist.history['val_accuracy']

loss = hist.history['loss']
val_loss = hist.history['val_loss']

epochs_range = range(epochs)

plt.figure(figsize=(8, 8))
plt.subplot(1, 2, 1)
plt.plot(epochs_range, acc, label='Training Accuracy')
plt.plot(epochs_range, val_acc, label='Validation Accuracy')
plt.legend(loc='lower right')
plt.title('Training and Validation Accuracy')

plt.subplot(1, 2, 2)
plt.plot(epochs_range, loss, label='Training Loss')
plt.plot(epochs_range, val_loss, label='Validation Loss')
plt.legend(loc='upper right')
plt.title('Training and Validation Loss')
plt.show()


#Augmentation des données

data_augmentation = keras.Sequential(
  [
    layers.RandomFlip("horizontal",
                      input_shape=(img_height,
                                  img_width,
                                  3)),
    layers.RandomRotation(0.1),
    layers.RandomZoom(0.1),
  ]
)

#Visualisons à quoi ressemblent quelques exemples augmentés en appliquant plusieurs fois l'augmentation de données à la même image :

plt.figure(figsize=(10, 10))
for images, _ in train_ds.take(1):
  for i in range(9):
    augmented_images = data_augmentation(images)
    ax = plt.subplot(3, 3, i + 1)
    plt.imshow(augmented_images[0].numpy().astype("uint8"))
    plt.axis("off")


#Abandonner
#Une autre technique pour réduire le surajustement consiste à introduire une régularisation des abandons dans le réseau.
#Lorsque vous appliquez une suppression à une couche, elle supprime de manière aléatoire (en définissant l'activation sur zéro) un certain nombre d'unités de sortie de la couche pendant le processus d'apprentissage. L'abandon prend un nombre fractionnaire comme valeur d'entrée, sous la forme de 0,1, 0,2, 0,4, etc. Cela signifie abandonner 10 %, 20 % ou 40 % des unités de sortie au hasard de la couche appliquée.
#Créons un nouveau réseau de neurones avec tf.keras.layers.Dropout avant de l'entraîner à l'aide des images augmentées :

model = Sequential([
  data_augmentation,
  layers.Rescaling(1./255),
  layers.Conv2D(16, 3, padding='same', activation='relu'),
  layers.MaxPooling2D(),
  layers.Conv2D(32, 3, padding='same', activation='relu'),
  layers.MaxPooling2D(),
  layers.Conv2D(64, 3, padding='same', activation='relu'),
  layers.MaxPooling2D(),
  layers.Dropout(0.2),
  layers.Flatten(),
  layers.Dense(128, activation='relu'),
  layers.Dense(num_classes)
])

#Compiler et entraîner le modèle

model.compile(optimizer='adam',
              loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
              metrics=['accuracy'])

model.summary()

epochs = 150  #etait a 15
history = model.fit(
  train_ds,
  validation_data=val_ds,
  epochs=epochs
)


#Visualisez les résultats de l'entraînement

acc = history.history['accuracy']
val_acc = history.history['val_accuracy']

loss = history.history['loss']
val_loss = history.history['val_loss']

epochs_range = range(epochs)

plt.figure(figsize=(8, 8))
plt.subplot(1, 2, 1)
plt.plot(epochs_range, acc, label='Training Accuracy')
plt.plot(epochs_range, val_acc, label='Validation Accuracy')
plt.legend(loc='lower right')
plt.title('Training and Validation Accuracy')

plt.subplot(1, 2, 2)
plt.plot(epochs_range, loss, label='Training Loss')
plt.plot(epochs_range, val_loss, label='Validation Loss')
plt.legend(loc='upper right')
plt.title('Training and Validation Loss')
plt.show()

model.evaluate(test_ds)

#import numpy

plt.figure(figsize=(10, 10))
for images, labels in test_ds.take(1):
    classifications = model(images)
    # print(classifications)

    for i in range(9):
        ax = plt.subplot(3, 3, i + 1)
        plt.imshow(images[i].numpy().astype("uint8"))
        index = numpy.argmax(classifications[i])
        plt.title("Pred: " + class_names[index] + " | Real: " + class_names[labels[i]])



#conversion du model en model tensorflow lite pour une utilisation sur android

converter = tf.lite.TFLiteConverter.from_keras_model(model)
tflite_model = converter.convert()

with open("modelPommeCerise11Objet2.tflite", 'wb') as f:
  f.write(tflite_model)
