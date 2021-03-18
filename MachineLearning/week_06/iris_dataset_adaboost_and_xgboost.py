# -*- coding: utf-8 -*-
"""Iris_Dataset_AdaBoost_And_XGBoost.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1WOsy9164NB1WOthzegN_ET5jOH7tztBu
"""

# Necessary import statements
from sklearn.ensemble import AdaBoostClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn import metrics

# load the iris dataset: 
iris_data = load_iris() 

# Set x as flower characteristics and y as target values:
x = iris_data.data[:,[2,3] ]
y = iris_data.target.reshape(-1, 1)

# Split the data for training and testing:
train_x, test_x, train_y, test_y = train_test_split(x, y, test_size=0.20)

# Create the ada boost classifier:
ada_clf = AdaBoostClassifier(
    DecisionTreeClassifier(max_depth=1,),
    n_estimators=200,
    algorithm="SAMME.R",
    learning_rate=0.5
)
ada_clf.fit(train_x, train_y.ravel() ) # The ravel allows me to have correct shape.

# Train ada_clf:
model = ada_clf.fit(train_x, train_y)

# Generate predictions:
pred_y = model.predict(test_x)

# Check how accurate the model is:
ada_boost_acc = metrics.accuracy_score(test_y, pred_y)
print("Accuracy:",ada_boost_acc)

# Compare above result with XG Boost:
import xgboost
import numpy as np

# Create the xgb model:
xgb_reg = xgboost.XGBRegressor()
xgb_reg.fit(train_x, train_y)

# Test the model:
xgb_pred_y = xgb_reg.predict(test_x)

# Round the model to find what it would be classified as:
rounded_xgb_pred_y = np.around(xgb_pred_y)

# Check how accurate the model is:
xgb_acc = metrics.accuracy_score(test_y, rounded_xgb_pred_y)
print("Accuracy:",xgb_acc)

# Result of comparison:
print("AdaBoost vs XGB Boost Accuracy:")
print("Ada Boost Accuracy:",ada_boost_acc)
print("XGB Boost Accuracy:",xgb_acc)