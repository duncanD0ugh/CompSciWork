#!/usr/bin/env python
# coding: utf-8

# In[1]:


print('---Task 1: Retrieving and Preparing the Data---')


# In[2]:


mice_p = 'Data_Cortex_Nuclear.xls'


# In[3]:


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import confusion_matrix
from sklearn.model_selection import KFold
from sklearn.tree import DecisionTreeClassifier


# In[4]:


mice = pd.read_excel(mice_p)


# In[5]:


print('---Task 1: Retrieving and Preparing the Data: Data Types---')


# In[6]:


mice.dtypes


# In[7]:


mice.MouseID.value_counts()


# In[8]:


mice.MouseID.astype(str)


# In[9]:


mice.Genotype.value_counts()


# In[10]:


mice.Genotype.astype(str)


# In[11]:


mice.Treatment.value_counts()


# In[12]:


mice.Treatment.astype(str)


# In[13]:


mice.Behavior.value_counts()


# In[14]:


mice.Behavior.astype(str)


# In[15]:


mice['class'].value_counts()


# In[16]:


mice['class'].astype(str)


# In[17]:


print('---Task 1: Retrieving and Preparing the Data: Typos AND Extra-whitespaces---')


# In[18]:


mice.MouseID.str.strip()
mice.Genotype.str.strip()
mice.Treatment.str.strip()
mice.Behavior.str.strip()
mice['class'].str.strip()


# In[19]:


mice.Genotype = mice.Genotype.replace('Ts65Dn', 'Trisomy', inplace = True)


# In[20]:


print('---Task 1: Retrieving and Preparing the Data: NaN Values---')


# In[21]:


mice.fillna(0, inplace = True)
#All String fields were verified with no NaN values, thus a broad NaN replacement for the float fields was appropriate


# In[22]:


print('---Task 2: Data Exploration: Explore a Column---')


# In[23]:


protein1 = mice.DYRK1A_N
protein2 = mice.ITSN1_N
protein3 = mice.BDNF_N
protein4 = mice.NR1_N
protein5 = mice.NR2A_N
protein6 = mice.pAKT_N
protein7 = mice.pBRAF_N
protein8 = mice.pCAMKII_N
protein9 = mice.pCREB_N
protein10 = mice.pELK_N


# In[24]:


protein1 = protein1.replace(0, np.NaN)
protein1mean = protein1.mean()

protein2 = protein2.replace(0, np.NaN)
protein2mean = protein2.mean()

protein3 = protein3.replace(0, np.NaN)
protein3mean = protein3.mean()

protein4 = protein4.replace(0, np.NaN)
protein4mean = protein4.mean()

protein5 = protein5.replace(0, np.NaN)
protein5mean = protein5.mean()

protein6 = protein6.replace(0, np.NaN)
protein6mean = protein6.mean()

protein7 = protein7.replace(0, np.NaN)
protein7mean = protein7.mean()

protein8 = protein8.replace(0, np.NaN)
protein8mean = protein8.mean()

protein9 = protein9.replace(0, np.NaN)
protein9mean = protein9.mean()

protein10 = protein10.replace(0, np.NaN)
protein10mean = protein10.mean()


# In[25]:


proteinMeanData = {'DYRK1A_N mean' : [protein1mean], 'ITSN1_N mean' : [protein2mean], 'BDNF_N mean' : [protein3mean], 
                   'NR1_N mean' : [protein4mean], 'NR2A_N mean' : [protein5mean], 'pAKT_N mean' : [protein6mean], 
                   'pBRAF_N mean' : [protein7mean], 'pCAMKII_N mean' : [protein8mean], 'pCREB_N mean' : [protein9mean], 
                   'pELK_N mean' : [protein10mean],}
proteinMeanTable = pd.DataFrame(data = proteinMeanData)
proteinMeanTable
#Exploration of 10 columns in 1 representation


# In[26]:


print('---Task 2: Data Exploration: Explore attribute relationships---')


# In[27]:


exp1 = mice[['DYRK1A_N', 'class']]
exp1 = exp1[exp1.DYRK1A_N != 0]

exp1class1 = exp1[exp1['class'] == 'c-CS-s']
class1avg = exp1class1.mean()

exp1class2 = exp1[exp1['class'] == 'c-CS-m']
class2avg = exp1class2.mean()

exp1class3 = exp1[exp1['class'] == 'c-SC-s']
class3avg = exp1class3.mean()

exp1class4 = exp1[exp1['class'] == 'c-SC-m']
class4avg = exp1class4.mean()

exp1class5 = exp1[exp1['class'] == 't-CS-s']
class5avg = exp1class5.mean()

exp1class6 = exp1[exp1['class'] == 't-CS-m']
class6avg = exp1class6.mean()

exp1class7 = exp1[exp1['class'] == 't-SC-s']
class7avg = exp1class7.mean()

exp1class8 = exp1[exp1['class'] == 't-SC-m']
class8avg = exp1class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[28]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein DYRK1A_N for each class of Mice')
plt.show()


# In[29]:


exp2 = mice[['ITSN1_N', 'class']]
exp2 = exp2[exp2.ITSN1_N != 0]

exp2class1 = exp2[exp2['class'] == 'c-CS-s']
class1avg = exp2class1.mean()

exp2class2 = exp2[exp2['class'] == 'c-CS-m']
class2avg = exp2class2.mean()

exp2class3 = exp2[exp2['class'] == 'c-SC-s']
class3avg = exp2class3.mean()

exp2class4 = exp2[exp2['class'] == 'c-SC-m']
class4avg = exp2class4.mean()

exp2class5 = exp2[exp2['class'] == 't-CS-s']
class5avg = exp2class5.mean()

exp2class6 = exp2[exp2['class'] == 't-CS-m']
class6avg = exp2class6.mean()

exp2class7 = exp2[exp2['class'] == 't-SC-s']
class7avg = exp2class7.mean()

exp2class8 = exp2[exp2['class'] == 't-SC-m']
class8avg = exp2class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[30]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein ITSN1_N for each class of Mice')
plt.show()


# In[31]:


exp3 = mice[['BDNF_N', 'class']]
exp3 = exp3[exp3.BDNF_N != 0]

exp3class1 = exp3[exp3['class'] == 'c-CS-s']
class1avg = exp3class1.mean()

exp3class2 = exp3[exp3['class'] == 'c-CS-m']
class2avg = exp3class2.mean()

exp3class3 = exp3[exp3['class'] == 'c-SC-s']
class3avg = exp3class3.mean()

exp3class4 = exp3[exp3['class'] == 'c-SC-m']
class4avg = exp3class4.mean()

exp3class5 = exp3[exp3['class'] == 't-CS-s']
class5avg = exp3class5.mean()

exp3class6 = exp3[exp3['class'] == 't-CS-m']
class6avg = exp3class6.mean()

exp3class7 = exp3[exp3['class'] == 't-SC-s']
class7avg = exp3class7.mean()

exp3class8 = exp3[exp3['class'] == 't-SC-m']
class8avg = exp3class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[32]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein BDNF_N for each class of Mice')
plt.show()


# In[33]:


exp4 = mice[['NR1_N', 'class']]
exp4 = exp4[exp4.NR1_N != 0]

exp4class1 = exp4[exp4['class'] == 'c-CS-s']
class1avg = exp4class1.mean()

exp4class2 = exp4[exp4['class'] == 'c-CS-m']
class2avg = exp4class2.mean()

exp4class3 = exp4[exp4['class'] == 'c-SC-s']
class3avg = exp4class3.mean()

exp4class4 = exp4[exp4['class'] == 'c-SC-m']
class4avg = exp4class4.mean()

exp4class5 = exp4[exp4['class'] == 't-CS-s']
class5avg = exp4class5.mean()

exp4class6 = exp4[exp4['class'] == 't-CS-m']
class6avg = exp4class6.mean()

exp4class7 = exp4[exp4['class'] == 't-SC-s']
class7avg = exp4class7.mean()

exp4class8 = exp4[exp4['class'] == 't-SC-m']
class8avg = exp4class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[34]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein NR1_N for each class of Mice')
plt.show()


# In[35]:


exp5 = mice[['NR2A_N', 'class']]
exp5 = exp5[exp5.NR2A_N != 0]

exp5class1 = exp5[exp5['class'] == 'c-CS-s']
class1avg = exp5class1.mean()

exp5class2 = exp5[exp5['class'] == 'c-CS-m']
class2avg = exp5class2.mean()

exp5class3 = exp5[exp5['class'] == 'c-SC-s']
class3avg = exp5class3.mean()

exp5class4 = exp5[exp5['class'] == 'c-SC-m']
class4avg = exp5class4.mean()

exp5class5 = exp5[exp5['class'] == 't-CS-s']
class5avg = exp5class5.mean()

exp5class6 = exp5[exp5['class'] == 't-CS-m']
class6avg = exp5class6.mean()

exp5class7 = exp5[exp5['class'] == 't-SC-s']
class7avg = exp5class7.mean()

exp5class8 = exp5[exp5['class'] == 't-SC-m']
class8avg = exp5class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[36]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein NR2A_N for each class of Mice')
plt.show()


# In[37]:


exp6 = mice[['pAKT_N', 'class']]
exp6 = exp6[exp6.pAKT_N != 0]

exp6class1 = exp6[exp6['class'] == 'c-CS-s']
class1avg = exp6class1.mean()

exp6class2 = exp6[exp6['class'] == 'c-CS-m']
class2avg = exp6class2.mean()

exp6class3 = exp6[exp6['class'] == 'c-SC-s']
class3avg = exp6class3.mean()

exp6class4 = exp6[exp6['class'] == 'c-SC-m']
class4avg = exp6class4.mean()

exp6class5 = exp6[exp6['class'] == 't-CS-s']
class5avg = exp6class5.mean()

exp6class6 = exp6[exp6['class'] == 't-CS-m']
class6avg = exp6class6.mean()

exp6class7 = exp6[exp6['class'] == 't-SC-s']
class7avg = exp6class7.mean()

exp6class8 = exp6[exp6['class'] == 't-SC-m']
class8avg = exp6class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[38]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein pAKT_N for each class of Mice')
plt.show()


# In[39]:


exp7 = mice[['pBRAF_N', 'class']]
exp7 = exp7[exp7.pBRAF_N != 0]

exp7class1 = exp7[exp7['class'] == 'c-CS-s']
class1avg = exp7class1.mean()

exp7class2 = exp7[exp7['class'] == 'c-CS-m']
class2avg = exp7class2.mean()

exp7class3 = exp7[exp7['class'] == 'c-SC-s']
class3avg = exp7class3.mean()

exp7class4 = exp7[exp7['class'] == 'c-SC-m']
class4avg = exp7class4.mean()

exp7class5 = exp7[exp7['class'] == 't-CS-s']
class5avg = exp7class5.mean()

exp7class6 = exp7[exp7['class'] == 't-CS-m']
class6avg = exp7class6.mean()

exp7class7 = exp7[exp7['class'] == 't-SC-s']
class7avg = exp7class7.mean()

exp7class8 = exp7[exp7['class'] == 't-SC-m']
class8avg = exp7class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[40]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein pBRAF_N for each class of Mice')
plt.show()


# In[41]:


exp8 = mice[['pCAMKII_N', 'class']]
exp8 = exp8[exp8.pCAMKII_N != 0]

exp8class1 = exp8[exp8['class'] == 'c-CS-s']
class1avg = exp8class1.mean()

exp8class2 = exp8[exp8['class'] == 'c-CS-m']
class2avg = exp8class2.mean()

exp8class3 = exp8[exp8['class'] == 'c-SC-s']
class3avg = exp8class3.mean()

exp8class4 = exp8[exp8['class'] == 'c-SC-m']
class4avg = exp8class4.mean()

exp8class5 = exp8[exp8['class'] == 't-CS-s']
class5avg = exp8class5.mean()

exp8class6 = exp8[exp8['class'] == 't-CS-m']
class6avg = exp8class6.mean()

exp8class7 = exp8[exp8['class'] == 't-SC-s']
class7avg = exp8class7.mean()

exp8class8 = exp8[exp8['class'] == 't-SC-m']
class8avg = exp8class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[42]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein pCAMKII_N for each class of Mice')
plt.show()


# In[43]:


exp9 = mice[['pCREB_N', 'class']]
exp9 = exp9[exp9.pCREB_N != 0]

exp9class1 = exp9[exp9['class'] == 'c-CS-s']
class1avg = exp9class1.mean()

exp9class2 = exp9[exp9['class'] == 'c-CS-m']
class2avg = exp9class2.mean()

exp9class3 = exp9[exp9['class'] == 'c-SC-s']
class3avg = exp9class3.mean()

exp9class4 = exp9[exp9['class'] == 'c-SC-m']
class4avg = exp9class4.mean()

exp9class5 = exp9[exp9['class'] == 't-CS-s']
class5avg = exp9class5.mean()

exp9class6 = exp9[exp9['class'] == 't-CS-m']
class6avg = exp9class6.mean()

exp9class7 = exp9[exp9['class'] == 't-SC-s']
class7avg = exp9class7.mean()

exp9class8 = exp9[exp9['class'] == 't-SC-m']
class8avg = exp9class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[44]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein pCREB_N for each class of Mice')
plt.show()


# In[45]:


exp10 = mice[['pELK_N', 'class']]
exp10 = exp10[exp10.pELK_N != 0]

exp10class1 = exp10[exp10['class'] == 'c-CS-s']
class1avg = exp10class1.mean()

exp10class2 = exp10[exp10['class'] == 'c-CS-m']
class2avg = exp10class2.mean()

exp10class3 = exp10[exp10['class'] == 'c-SC-s']
class3avg = exp10class3.mean()

exp10class4 = exp10[exp10['class'] == 'c-SC-m']
class4avg = exp10class4.mean()

exp10class5 = exp10[exp10['class'] == 't-CS-s']
class5avg = exp10class5.mean()

exp10class6 = exp10[exp10['class'] == 't-CS-m']
class6avg = exp10class6.mean()

exp10class7 = exp10[exp10['class'] == 't-SC-s']
class7avg = exp10class7.mean()

exp10class8 = exp10[exp10['class'] == 't-SC-m']
class8avg = exp10class8.mean()

classAvgData = {'c-CS-s' : class1avg, 'c-CS-m' : class2avg, 'c-SC-s' : class3avg, 'c-SC-m' : class4avg
               ,'t-CS-s' : class5avg, 't-CS-m' : class6avg, 't-SC-s' : class7avg, 't-SC-m' : class8avg}
classAvgs = pd.DataFrame(data = classAvgData)
classAvgs


# In[46]:


row = classAvgs.iloc[0]
row.plot(kind='bar', title = 'Average expression levels of protein pELK_N for each class of Mice')
plt.show()


# In[47]:


print('---Task 3: Data Modelling---')


# In[48]:


miceTarget = mice['class']
miceData = mice
del miceData['MouseID']
del miceData['Genotype']
del miceData['Treatment']
del miceData['Behavior']
del miceData['class']


# In[49]:


miceTarget


# In[50]:


miceTarget.shape


# In[51]:


miceData


# In[52]:


miceData.shape


# In[53]:


x_train, x_test, y_train, y_test =train_test_split(miceData,miceTarget,test_size=0.5,random_state=4)


# In[54]:


x_train


# In[55]:


x_train.shape


# In[56]:


y_train


# In[57]:


y_train.shape


# In[58]:


x_test


# In[59]:


x_test.shape


# In[60]:


y_test


# In[61]:


y_test.shape


# In[62]:


knn = KNeighborsClassifier(n_neighbors = 1, weights = 'uniform', metric = 'minkowski', p = 2)
knn.fit(x_train, y_train)
predicted = knn.predict(x_test)
cm = confusion_matrix(y_test,predicted)
print(cm)


# In[63]:


print("[Train/test split] score: {:.5f}".format(knn.score(x_test, y_test)))


# In[64]:


kf = KFold(n_splits = 5, random_state = 4, shuffle = True)


# In[65]:


for train_index, test_index in kf.split(miceData):
    print("TRAIN:", train_index, "TEST:", test_index)
    x_train, x_test = miceData.iloc[train_index], miceData.iloc[test_index]
    y_train, y_test = miceTarget.iloc[train_index], miceTarget.iloc[test_index]


# In[66]:


for k, (train_index, test_index) in enumerate(kf.split(miceData)):
    x_train, x_test = miceData.iloc[train_index], miceData.iloc[test_index]
    y_train, y_test = miceTarget.iloc[train_index], miceTarget.iloc[test_index]
    knn.fit(x_train, y_train)
    print("[fold {0}] score: {1:.5f}".format(k, knn.score(x_test, y_test)))


# In[67]:


print("KNN mean score [5 folds] = 0.989814")


# In[68]:


dtc = DecisionTreeClassifier(criterion = 'gini', splitter = 'best')
fit = dtc.fit(x_train, y_train)
y_pre = fit.predict(x_test)
cm = confusion_matrix(y_test, y_pre)
print(cm)


# In[69]:


print("[Train/test split] score: {:.5f}".format(dtc.score(x_test, y_test)))


# In[1]:


for k, (train_index, test_index) in enumerate(kf.split(miceData)):
    x_train, x_test = miceData.iloc[train_index], miceData.iloc[test_index]
    y_train, y_test = miceTarget.iloc[train_index], miceTarget.iloc[test_index]
    dtc.fit(x_train, y_train)
    print("[fold {0}] score: {1:.5f}".format(k, dtc.score(x_test, y_test)))


# In[71]:


print("DT mean score [5 folds] = 0.873148")


# In[ ]:




