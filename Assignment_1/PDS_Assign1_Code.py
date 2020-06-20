#!/usr/bin/env python
# coding: utf-8

# In[1]:


print('---Task 1.1: Data Retrieving---')


# In[2]:


starwars_p = 'StarWars.csv'


# In[3]:


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt


# In[4]:


starwars = pd.read_csv(starwars_p, encoding = 'unicode_escape', sep=',', decimal='.', skiprows=2, 
header=None, names = ['RespondentID', 'Seen_Any_Film', 
                      'Starwars_Fan', 
                      'Seen_Episode_1', 'Seen_Episode_2', 'Seen_Episode_3', 'Seen_Episode_4', 'Seen_Episode_5', 
                      'Seen_Episode_6', 'Rank_Episode_1', 'Rank_Episode_2', 'Rank_Episode_3', 'Rank_Episode_4', 
                      'Rank_Episode_5', 'Rank_Episode_6', 'Rank_Han_Solo', 'Rank_Luke_Skywalker', 'Rank_Princess_Leia', 
                      'Rank_Anakin_Skywalker', 'Rank_Obiwan_Kenobi', 'Rank_Emperor_Palpatine', 'Rank_Darth_Vader', 
                      'Rank_Lando_Calrissian', 'Rank_Boba_Fett', 'Rank_C3PO', 'Rank_R2_D2', 'Rank_Jar_Jar_Binks', 
                      'Rank_Padme_Amidala', 'Rank_Yoda', 'Who_Shot_First', 'Know_The_EU',
                      'Fan_Of_EU', 'Star_Trek_Fan', 'Gender', 'Age', 
                      'Household_Income', 'Education', 'Location'])


# In[5]:


print('---Task 1.2: Check data types---\nAND\n---Task 1.7: Missing values---')


# In[6]:


starwars.dtypes


# In[7]:


starwars.Seen_Any_Film = starwars.Seen_Any_Film.astype(str)
starwars.Seen_Any_Film.fillna('Empty', inplace = True)


# In[8]:


starwars.Seen_Episode_1 = starwars.Seen_Episode_1.astype(str)
starwars.Seen_Episode_1.fillna('Empty', inplace = True)


# In[9]:


starwars.Seen_Episode_2 = starwars.Seen_Episode_2.astype(str)
starwars.Seen_Episode_2.fillna('Empty', inplace = True)


# In[10]:


starwars.Seen_Episode_3 = starwars.Seen_Episode_3.astype(str)
starwars.Seen_Episode_3.fillna('Empty', inplace = True)


# In[11]:


starwars.Seen_Episode_4 = starwars.Seen_Episode_4.astype(str)
starwars.Seen_Episode_4.fillna('Empty', inplace = True)


# In[12]:


starwars.Seen_Episode_5 = starwars.Seen_Episode_5.astype(str)
starwars.Seen_Episode_5.fillna('Empty', inplace = True)


# In[13]:


starwars.Seen_Episode_6 = starwars.Seen_Episode_6.astype(str)
starwars.Seen_Episode_6.fillna('Empty', inplace = True)


# In[14]:


starwars.Rank_Episode_1.fillna(0, inplace=True)
starwars.Rank_Episode_1 = starwars.Rank_Episode_1.astype(int)


# In[15]:


starwars.Rank_Episode_2.fillna(0, inplace=True)
starwars.Rank_Episode_2 = starwars.Rank_Episode_2.astype(int)


# In[16]:


starwars.Rank_Episode_3.fillna(0, inplace=True)
starwars.Rank_Episode_3 = starwars.Rank_Episode_3.astype(int)


# In[17]:


starwars.Rank_Episode_4.fillna(0, inplace=True)
starwars.Rank_Episode_4 = starwars.Rank_Episode_4.astype(int)


# In[18]:


starwars.Rank_Episode_5.fillna(0, inplace=True)
starwars.Rank_Episode_5 = starwars.Rank_Episode_5.astype(int)


# In[19]:


starwars.Rank_Episode_6.fillna(0, inplace=True)
starwars.Rank_Episode_6 = starwars.Rank_Episode_6.astype(int)


# In[20]:


starwars.Rank_Han_Solo.fillna('No Comment', inplace=True)
starwars.Rank_Han_Solo = starwars.Rank_Han_Solo.astype(str)


# In[21]:


starwars.Rank_Luke_Skywalker.fillna('No Comment', inplace=True)
starwars.Rank_Luke_Skywalker = starwars.Rank_Luke_Skywalker.astype(str)


# In[22]:


starwars.Rank_Princess_Leia.fillna('No Comment', inplace=True)
starwars.Rank_Princess_Leia = starwars.Rank_Princess_Leia.astype(str)


# In[23]:


starwars.Rank_Anakin_Skywalker.fillna('No Comment', inplace=True)
starwars.Rank_Anakin_Skywalker = starwars.Rank_Anakin_Skywalker.astype(str)


# In[24]:


starwars.Rank_Obiwan_Kenobi.fillna('No Comment', inplace=True)
starwars.Rank_Obiwan_Kenobi = starwars.Rank_Obiwan_Kenobi.astype(str)


# In[25]:


starwars.Rank_Emperor_Palpatine.fillna('No Comment', inplace=True)
starwars.Rank_Emperor_Palpatine = starwars.Rank_Emperor_Palpatine.astype(str)


# In[26]:


starwars.Rank_Darth_Vader.fillna('No Comment', inplace=True)
starwars.Rank_Darth_Vader = starwars.Rank_Darth_Vader.astype(str)


# In[27]:


starwars.Rank_Lando_Calrissian.fillna('No Comment', inplace=True)
starwars.Rank_Lando_Calrissian = starwars.Rank_Lando_Calrissian.astype(str)


# In[28]:


starwars.Rank_Boba_Fett.fillna('No Comment', inplace=True)
starwars.Rank_Boba_Fett = starwars.Rank_Boba_Fett.astype(str)


# In[29]:


starwars.Rank_C3PO.fillna('No Comment', inplace=True)
starwars.Rank_C3PO = starwars.Rank_C3PO.astype(str)


# In[30]:


starwars.Rank_R2_D2.fillna('No Comment', inplace=True)
starwars.Rank_R2_D2 = starwars.Rank_R2_D2.astype(str)


# In[31]:


starwars.Rank_Jar_Jar_Binks.fillna('No Comment', inplace=True)
starwars.Rank_Jar_Jar_Binks = starwars.Rank_Jar_Jar_Binks.astype(str)


# In[32]:


starwars.Rank_Padme_Amidala.fillna('No Comment', inplace=True)
starwars.Rank_Padme_Amidala = starwars.Rank_Padme_Amidala.astype(str)


# In[33]:


starwars.Rank_Yoda.fillna('No Comment', inplace=True)
starwars.Rank_Yoda = starwars.Rank_Yoda.astype(str)


# In[34]:


starwars.Who_Shot_First.fillna('No Comment', inplace=True)
starwars.Who_Shot_First = starwars.Who_Shot_First.astype(str)


# In[35]:


starwars.Know_The_EU = starwars.Know_The_EU.astype(str)
starwars.Know_The_EU.fillna('No Comment', inplace=True)


# In[36]:


starwars.Fan_Of_EU = starwars.Fan_Of_EU.astype(str)
starwars.Fan_Of_EU.fillna('No Comment', inplace=True)


# In[37]:


starwars.Star_Trek_Fan = starwars.Star_Trek_Fan.astype(str)
starwars.Star_Trek_Fan.fillna('No Comment', inplace=True)


# In[38]:


starwars.Gender = starwars.Gender.astype(str)
starwars.Gender.fillna('No Comment', inplace=True)


# In[39]:


starwars.Age = starwars.Age.astype(str)
starwars.Age = starwars.Age.fillna('No Comment', inplace=True)


# In[40]:


starwars.Household_Income = starwars.Household_Income.astype(str)
starwars.Household_Income.fillna('No Comment', inplace=True)


# In[41]:


starwars.Education = starwars.Education.astype(str)
starwars.Education.fillna('No Comment', inplace=True)


# In[42]:


starwars.Location = starwars.Location.astype(str)
starwars.Location.fillna('No Comment', inplace=True)


# In[43]:


starwars.dtypes


# In[44]:


print('---Task 1.3: Typos---\nAND\n---Task 1.4: Extra-whitepaces---\nAND\n---Task 1.5: Upper/Lower-case---\nAND\n---Task 1.6: Sanity checks---')


# In[45]:


starwars.Seen_Any_Film.value_counts()


# In[46]:


starwars.Seen_Any_Film.str.strip()


# In[47]:


starwars.Starwars_Fan.value_counts()


# In[48]:


starwars.Starwars_Fan.str.strip()
starwars.Starwars_Fan = starwars.Starwars_Fan.replace('Yess', 'Yes', inplace = True)
starwars.Starwars_Fan = starwars.Starwars_Fan.replace('Noo', 'No', inplace = True)


# In[49]:


starwars.Seen_Episode_1.value_counts()


# In[50]:


starwars.Seen_Episode_1.replace('nan', 'Empty', inplace = True)


# In[51]:


starwars.Seen_Episode_2.value_counts()


# In[52]:


starwars.Seen_Episode_2.replace('nan', 'Empty', inplace = True)


# In[53]:


starwars.Seen_Episode_3.value_counts()


# In[54]:


starwars.Seen_Episode_3.replace('nan', 'Empty', inplace = True)


# In[55]:


starwars.Seen_Episode_4.value_counts()


# In[56]:


starwars.Seen_Episode_4.replace('nan', 'Empty', inplace = True)


# In[57]:


starwars.Seen_Episode_5.value_counts()


# In[58]:


starwars.Seen_Episode_5.replace('nan', 'Empty', inplace = True)


# In[59]:


starwars.Seen_Episode_6.value_counts()


# In[60]:


starwars.Seen_Episode_6.replace('nan', 'Empty', inplace = True)


# In[61]:


starwars.Rank_Episode_1.value_counts()


# In[62]:


starwars.Rank_Episode_2.value_counts()


# In[63]:


starwars.Rank_Episode_3.value_counts()


# In[64]:


starwars.Rank_Episode_4.value_counts()


# In[65]:


starwars.Rank_Episode_5.value_counts()


# In[66]:


starwars.Rank_Episode_6.value_counts()


# In[67]:


starwars.Rank_Han_Solo.value_counts()


# In[68]:


starwars.Rank_Luke_Skywalker.value_counts()


# In[69]:


starwars.Rank_Princess_Leia.value_counts()


# In[70]:


starwars.Rank_Anakin_Skywalker.value_counts()


# In[71]:


starwars.Rank_Obiwan_Kenobi.value_counts()


# In[72]:


starwars.Rank_Emperor_Palpatine.value_counts()


# In[73]:


starwars.Rank_Darth_Vader.value_counts()


# In[74]:


starwars.Rank_Lando_Calrissian.value_counts()


# In[75]:


starwars.Rank_Boba_Fett.value_counts()


# In[76]:


starwars.Rank_C3PO.value_counts()


# In[77]:


starwars.Rank_R2_D2.value_counts()


# In[78]:


starwars.Rank_Jar_Jar_Binks.value_counts()


# In[79]:


starwars.Rank_Padme_Amidala.value_counts()


# In[80]:


starwars.Rank_Yoda.value_counts()


# In[81]:


starwars.Who_Shot_First.value_counts() #'I don't understand this question' was deemed an acceptable answer"


# In[82]:


starwars.Know_The_EU.value_counts()


# In[83]:


starwars.Know_The_EU.replace('nan', 'Empty', inplace = True)


# In[84]:


starwars.Fan_Of_EU.value_counts()


# In[85]:


starwars.Fan_Of_EU.replace('nan', 'Empty', inplace = True)
starwars.Fan_Of_EU.replace('Yess', 'Yes', inplace = True)


# In[86]:


starwars.Star_Trek_Fan.value_counts()


# In[87]:


starwars.Star_Trek_Fan.str.strip()
starwars.Star_Trek_Fan.replace('nan', 'Empty', inplace = True)
starwars.Star_Trek_Fan.replace('Noo', 'No', inplace = True)
starwars.Star_Trek_Fan.replace('no', 'No', inplace = True)
starwars.Star_Trek_Fan.replace('yes', 'Yes', inplace = True)


# In[88]:


starwars.Gender.value_counts()


# In[89]:


starwars.Gender.replace('female', 'Female', inplace = True)
starwars.Gender.replace('male', 'Male', inplace = True)
starwars.Gender.replace('f', 'Female', inplace = True)
starwars.Gender.replace('F', 'Female', inplace = True)
starwars.Gender.replace('nan', 'Empty', inplace = True)


# In[90]:


starwars.Age.value_counts()


# In[91]:


starwars.Age.replace('500', 'No Comment', inplace = True)
#                 '500' was deemed an impossible value (Unless you're of Yoda's species)


# In[92]:


starwars.Household_Income.value_counts()


# In[93]:


starwars.Education.value_counts()


# In[94]:


starwars.Location.value_counts()


# In[95]:


starwars.Location.replace('East North Central', 'North-East Central', inplace = True)
starwars.Location.replace('West South Central', 'South-West Central', inplace = True)
starwars.Location.replace('West North Central', 'North-West Central', inplace = True)
starwars.Location.replace('East South Central', 'South-East Central', inplace = True)
starwars.Location.replace('Mountain', 'No Comment', inplace = True)
#                 It is unclear what deems an "invalid/impossible" location, 
#                 thus corrections were only done to direction formatting and the obvious deletion of "Mountain"


# In[96]:


print('---Task 2.1: Explore a survey question---')


# In[97]:


movieRanks = starwars[['Rank_Episode_1', 'Rank_Episode_2', 'Rank_Episode_3', 
                       'Rank_Episode_4', 'Rank_Episode_5', 'Rank_Episode_6']]
movieRanks


# In[98]:


starwars1Rank = starwars['Rank_Episode_1'].replace(0, np.NaN)
ep1Mean = starwars1Rank.mean()

starwars2Rank = starwars['Rank_Episode_2'].replace(0, np.NaN)
ep2Mean = starwars2Rank.mean()

starwars3Rank = starwars['Rank_Episode_3'].replace(0, np.NaN)
ep3Mean = starwars3Rank.mean()

starwars4Rank = starwars['Rank_Episode_4'].replace(0, np.NaN)
ep4Mean = starwars4Rank.mean()

starwars5Rank = starwars['Rank_Episode_5'].replace(0, np.NaN)
ep5Mean = starwars5Rank.mean()

starwars6Rank = starwars['Rank_Episode_6'].replace(0, np.NaN)
ep6Mean = starwars6Rank.mean()

# The NaN's were made 0s in order to convert the column to an int data type. In order to calculate an accurate average for 
# the movie's rank, they must be neglected.

movieAvgsData = {'Episode 1 avg': [ep1Mean], 'Episode 2 avg': [ep2Mean], 'Episode 3 avg': [ep3Mean], 
                 'Episode 4 avg': [ep4Mean], 'Episode 5 avg': [ep5Mean], 'Episode 6 avg': [ep6Mean]}
movieAvgs = pd.DataFrame(data = movieAvgsData)
movieAvgs


# In[99]:


ogTrilMean = (starwars4Rank.mean() + starwars4Rank.mean() + starwars4Rank.mean())/3
ogTrilMean


# In[100]:


preTrilMean = (starwars1Rank.mean() + starwars2Rank.mean() + starwars3Rank.mean())/3
preTrilMean


# In[101]:


movieRanks['Rank_Episode_1'].value_counts()


# In[102]:


movieRanks['Rank_Episode_2'].value_counts()


# In[103]:


movieRanks['Rank_Episode_3'].value_counts()


# In[104]:


movieRanks['Rank_Episode_4'].value_counts()


# In[105]:


movieRanks['Rank_Episode_5'].value_counts()


# In[106]:


ep6table = movieRanks['Rank_Episode_6'].value_counts()


# In[107]:


# ---Analysis---
# It appears the popularity of Star Wars movies, from most popular to least is as followed:
#     Star Wars Episode 5: Revenge of the Sith
#     Star Wars Episode 6: Return of the Jedi
#     Star Wars Episode 4: A New Hope
#     Star Wars Episode 1: The Phantom Menace
#     Star Wars Episode 2: Attack of the Clones
#     Star Wars Episode 3: Revenge of the Sith
        
# This is from an average statistic of all votes (1 point to 6) taken into consideration.

# In terms of which was the most frequent favourite movie, Episode 5 wins, with 34.6% of voters ranking it number 1. 
# On the contrary of frequency of being the favourite movie, Episode 2 ranked last with 0.04% of voters ranking it number 1.

# On the other hand, in terms of which was the most frequent LEAST favourite movie, Episode 2 had 35.9% of voters ranking
# it number 6. On the contrary of frequency of being the least favourite movie, Episode 6 had ZERO percent of voters ranking it
# number 6.


# In[108]:


print('---Task 2.2: Relationships between columns---')


# In[109]:


movieRanksST = starwars[['Rank_Episode_1', 'Rank_Episode_2', 'Rank_Episode_3', 
                       'Rank_Episode_4', 'Rank_Episode_5', 'Rank_Episode_6', 'Star_Trek_Fan']]
movieRanksST = movieRanks[starwars['Star_Trek_Fan'] == 'Yes']

starwars1Rank = movieRanksST['Rank_Episode_1'].replace(0, np.NaN)
ep1Mean = starwars1Rank.mean()

starwars2Rank = movieRanksST['Rank_Episode_2'].replace(0, np.NaN)
ep2Mean = starwars2Rank.mean()

starwars3Rank = movieRanksST['Rank_Episode_3'].replace(0, np.NaN)
ep3Mean = starwars3Rank.mean()

starwars4Rank = movieRanksST['Rank_Episode_4'].replace(0, np.NaN)
ep4Mean = starwars4Rank.mean()

starwars5Rank = movieRanksST['Rank_Episode_5'].replace(0, np.NaN)
ep5Mean = starwars5Rank.mean()

starwars6Rank = movieRanksST['Rank_Episode_6'].replace(0, np.NaN)
ep6Mean = starwars6Rank.mean()

movieAvgsData = {'Episode 1 avg': [ep1Mean], 'Episode 2 avg': [ep2Mean], 'Episode 3 avg': [ep3Mean], 
                 'Episode 4 avg': [ep4Mean], 'Episode 5 avg': [ep5Mean], 'Episode 6 avg': [ep6Mean]}
movieAvgs = pd.DataFrame(data = movieAvgsData)

invEp1 = 6 - movieAvgs['Episode 1 avg'][0]
invEp2 = 6 - movieAvgs['Episode 2 avg'][0]
invEp3 = 6 - movieAvgs['Episode 3 avg'][0]
invEp4 = 6 - movieAvgs['Episode 4 avg'][0]
invEp5 = 6 - movieAvgs['Episode 5 avg'][0]
invEp6 = 6 - movieAvgs['Episode 6 avg'][0]
inverseMovieAvgsData = {'Episode 1': [invEp1], 'Episode 2': [invEp2], 'Episode 3': [invEp3], 
                        'Episode 4': [invEp4], 'Episode 5': [invEp5], 'Episode 6': [invEp6]}
inverseMovieAvgs = pd.DataFrame(data = inverseMovieAvgsData)
inverseMovieAvgs


# In[110]:


row = inverseMovieAvgs.iloc[0]
row.plot(kind='pie', title = 'Most favoured Star Wars movies of Star Trek Fans')
plt.show()


# In[111]:


eu = starwars
eu = eu[eu['Fan_Of_EU'] == 'Yes']

characterData = {'Han Solo': eu['Rank_Han_Solo'].value_counts(), 
                 'Luke Skywalker': eu['Rank_Luke_Skywalker'].value_counts(),
                 'Princess Leia': eu['Rank_Princess_Leia'].value_counts(), 
                 'Anakin Skywalker': eu['Rank_Anakin_Skywalker'].value_counts(), 
                 'Obiwan Kenobi': eu['Rank_Obiwan_Kenobi'].value_counts(), 
                 'Emperor Palpatine': eu['Rank_Emperor_Palpatine'].value_counts(),
                 'Darth Vader': eu['Rank_Darth_Vader'].value_counts(), 
                 'Lando Calrissian': eu['Rank_Lando_Calrissian'].value_counts(),
                 'Boba Fett': eu['Rank_Boba_Fett'].value_counts(), 
                 'C-3PO': eu['Rank_C3PO'].value_counts(), 
                 'R2 D2': eu['Rank_R2_D2'].value_counts(), 
                 'Jar Jar Binks': eu['Rank_Jar_Jar_Binks'].value_counts(), 
                 'Padme Amidala': eu['Rank_Padme_Amidala'].value_counts(), 
                 'Yoda': eu['Rank_Yoda'].value_counts()}

characters = pd.DataFrame(data = characterData)
characters = characters.drop(['No Comment', 'Unfamiliar (N/A)'])
characters.rename(index = {
    'Neither favorably nor unfavorably (neutral)': '3',
    'Somewhat favorably': '4',
    'Very favorably': '5',
    'Somewhat unfavorably': '2',
    'Very unfavorably': '1'
}, inplace = True)

HanSoloData = 1*characters['Han Solo'][4] + 2*characters['Han Solo'][2] + 3*characters['Han Solo'][0] + 4*characters['Han Solo'][1] + 5*characters['Han Solo'][3] 
HanSoloAvg = HanSoloData/characters['Han Solo'].sum()

LukeSkywalkerData = 1*characters['Luke Skywalker'][4] + 2*characters['Luke Skywalker'][2] + 3*characters['Luke Skywalker'][0] + 4*characters['Luke Skywalker'][1] + 5*characters['Luke Skywalker'][3] 
LukeSkywalkerAvg = LukeSkywalkerData/characters['Luke Skywalker'].sum()

PrincessLeiaData = 1*characters['Princess Leia'][4] + 2*characters['Princess Leia'][2] + 3*characters['Princess Leia'][0] + 4*characters['Princess Leia'][1] + 5*characters['Princess Leia'][3] 
PrincessLeiaAvg = PrincessLeiaData/characters['Princess Leia'].sum()

AnakinSkywalkerData = 1*characters['Anakin Skywalker'][4] + 2*characters['Anakin Skywalker'][2] + 3*characters['Anakin Skywalker'][0] + 4*characters['Anakin Skywalker'][1] + 5*characters['Anakin Skywalker'][3] 
AnakinSkywalkerAvg = AnakinSkywalkerData/characters['Anakin Skywalker'].sum()

ObiwanKenobiData = 1*characters['Obiwan Kenobi'][4] + 2*characters['Obiwan Kenobi'][2] + 3*characters['Obiwan Kenobi'][0] + 4*characters['Obiwan Kenobi'][1] + 5*characters['Obiwan Kenobi'][3] 
ObiwanKenobiAvg = ObiwanKenobiData/characters['Obiwan Kenobi'].sum()

EmperorPalpatineData = 1*characters['Emperor Palpatine'][4] + 2*characters['Emperor Palpatine'][2] + 3*characters['Emperor Palpatine'][0] + 4*characters['Emperor Palpatine'][1] + 5*characters['Emperor Palpatine'][3] 
EmperorPalpatineAvg = EmperorPalpatineData/characters['Emperor Palpatine'].sum()

DarthVaderData = 1*characters['Darth Vader'][4] + 2*characters['Darth Vader'][2] + 3*characters['Darth Vader'][0] + 4*characters['Darth Vader'][1] + 5*characters['Darth Vader'][3] 
DarthVaderAvg = DarthVaderData/characters['Darth Vader'].sum()

LandoCalrissianData = 1*characters['Lando Calrissian'][4] + 2*characters['Lando Calrissian'][2] + 3*characters['Lando Calrissian'][0] + 4*characters['Lando Calrissian'][1] + 5*characters['Lando Calrissian'][3] 
LandoCalrissianAvg = LandoCalrissianData/characters['Lando Calrissian'].sum()

BobaFettData = 1*characters['Boba Fett'][4] + 2*characters['Boba Fett'][2] + 3*characters['Boba Fett'][0] + 4*characters['Boba Fett'][1] + 5*characters['Boba Fett'][3] 
BobaFettAvg = BobaFettData/characters['Boba Fett'].sum()

C3POData = 1*characters['C-3PO'][4] + 2*characters['C-3PO'][2] + 3*characters['C-3PO'][0] + 4*characters['C-3PO'][1] + 5*characters['C-3PO'][3] 
C3POAvg = C3POData/characters['C-3PO'].sum()

R2D2Data = 1*characters['R2 D2'][4] + 2*characters['R2 D2'][2] + 3*characters['R2 D2'][0] + 4*characters['R2 D2'][1] + 5*characters['R2 D2'][3] 
R2D2Avg = R2D2Data/characters['R2 D2'].sum()

JarJarBinksData = 1*characters['Jar Jar Binks'][4] + 2*characters['Jar Jar Binks'][2] + 3*characters['Jar Jar Binks'][0] + 4*characters['Jar Jar Binks'][1] + 5*characters['Jar Jar Binks'][3] 
JarJarBinksAvg = JarJarBinksData/characters['Jar Jar Binks'].sum()

PadmeAmidalaData = 1*characters['Padme Amidala'][4] + 2*characters['Padme Amidala'][2] + 3*characters['Padme Amidala'][0] + 4*characters['Padme Amidala'][1] + 5*characters['Padme Amidala'][3] 
PadmeAmidalaAvg = PadmeAmidalaData/characters['Padme Amidala'].sum()

YodaData = 1*characters['Yoda'][4] + 2*characters['Yoda'][2] + 3*characters['Yoda'][0] + 4*characters['Yoda'][1] + 5*characters['Yoda'][3] 
YodaAvg = YodaData/characters['Yoda'].sum()

graphData = {'Han Solo': [HanSoloAvg], 
                 'Luke Skywalker': [LukeSkywalkerAvg],
                 'Princess Leia': [PrincessLeiaAvg], 
                 'Anakin Skywalker': [AnakinSkywalkerAvg], 
                 'Obiwan Kenobi': [ObiwanKenobiAvg], 
                 'Emperor Palpatine': [EmperorPalpatineAvg],
                 'Darth Vader': [DarthVaderAvg], 
                 'Lando Calrissian': [LandoCalrissianAvg],
                 'Boba Fett': [BobaFettAvg], 
                 'C-3PO': [C3POAvg], 
                 'R2 D2': [R2D2Avg], 
                 'Jar Jar Binks': [JarJarBinksAvg], 
                 'Padme Amidala': [PadmeAmidalaAvg], 
                 'Yoda': YodaAvg}
graph = pd.DataFrame(data = graphData)
graph


# In[112]:


row = graph.iloc[0]
row.plot(kind='pie', title = 'Most favoured Star Wars characters of Expanded Universe Fans')
plt.show()


# In[113]:


gender = starwars
gender['Gender'].value_counts()
gender = gender[gender['Gender'] != 'Empty']

seenTable = gender[gender['Seen_Any_Film'] == 'Yes']
seenTable['Gender'].value_counts().plot(kind = 'pie', title = 'Gender of Star Wars viewers')
plt.show()

unseenTable = gender[gender['Seen_Any_Film'] == 'No']
unseenTable['Gender'].value_counts().plot(kind = 'pie', title = 'Gender of NON Star Wars viewers')
plt.show()


# In[114]:


print('---Task 2.3: Explore a specific relationship---')


# In[115]:


HanSoloData = {'Han Solo Opinion': starwars['Rank_Han_Solo'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
HanSoloTable = pd.DataFrame(data = HanSoloData)
HanSoloTable = HanSoloTable[HanSoloTable['Han Solo Opinion'] != 'No Comment']

#Gender
HS_Gender_M = HanSoloTable[HanSoloTable['Gender'] == 'Male']
HS_Gender_M['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Gender = Male>')
plt.show()

HS_Gender_F = HanSoloTable[HanSoloTable['Gender'] == 'Female']
HS_Gender_F['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Gender = Female>')
plt.show()

#Age
HS_Age_18_29 = HanSoloTable[HanSoloTable['Age'] == '18-29']
HS_Age_18_29

HS_Age_30_44 = HanSoloTable[HanSoloTable['Age'] == '30-44']
HS_Age_30_44

HS_Age_45_60 = HanSoloTable[HanSoloTable['Age'] == '45-60']
HS_Age_45_60

HS_Age_60 = HanSoloTable[HanSoloTable['Age'] == '> 60']
HS_Age_60

#Household Income
HS_HI_0 = HanSoloTable[HanSoloTable['Household Income'] == '$0 - $24,999']
HS_HI_0['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Household Income = $0 - $24,999>')
plt.show()

HS_HI_25 = HanSoloTable[HanSoloTable['Household Income'] == '$25,000 - $49,999']
HS_HI_25['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Household Income = $25,000 - $49,999>')
plt.show()

HS_HI_50 = HanSoloTable[HanSoloTable['Household Income'] == '$50,000 - $99,999']
HS_HI_50['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Household Income = $50,000 - $99,999>')
plt.show()

HS_HI_100 = HanSoloTable[HanSoloTable['Household Income'] == '$100,000 - $149,999']
HS_HI_100['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Household Income = $100,000 - $149,999>')
plt.show()

HS_HI_150 = HanSoloTable[HanSoloTable['Household Income'] == '$150,000+']
HS_HI_150['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Household Income = $150,000+>')
plt.show()

#Education
HS_E_LessHS = HanSoloTable[HanSoloTable['Education'] == 'Less than high school degree']
HS_E_LessHS['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Education = Less than high school degree>')
plt.show()

HS_E_HS = HanSoloTable[HanSoloTable['Education'] == 'High school degree']
HS_E_HS['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Education = High school degree>')
plt.show()

HS_E_C_AD = HanSoloTable[HanSoloTable['Education'] == 'Some college or Associate degree']
HS_E_C_AD['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Education = Some college or Associate degree>')
plt.show()

HS_E_BD = HanSoloTable[HanSoloTable['Education'] == 'Bachelor degree']
HS_E_BD['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Education = Bachelor degree>')
plt.show()

HS_E_GD = HanSoloTable[HanSoloTable['Education'] != 'Graduate degree']
HS_E_GD['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Education = Graduate degree>')
plt.show()

#Location
HS_L_NEC = HanSoloTable[HanSoloTable['Location'] == 'North-East Central']
HS_L_NEC['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = North-East Central>')
plt.show()

HS_L_P = HanSoloTable[HanSoloTable['Location'] == 'Pacific']
HS_L_P['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = Pacific>')
plt.show()

HS_L_SA = HanSoloTable[HanSoloTable['Location'] == 'South Atlantic']
HS_L_SA['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = South Atlantic>')
plt.show()

HS_L_MA = HanSoloTable[HanSoloTable['Location'] == 'Middle Atlantic']
HS_L_MA['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = Middle Atlantic>')
plt.show()

HS_L_SWC = HanSoloTable[HanSoloTable['Location'] == 'South-West Central']
HS_L_SWC['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = South-West Central>')
plt.show()

HS_L_NWC = HanSoloTable[HanSoloTable['Location'] == 'North-West Central']
HS_L_NWC['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = North-West Central>')
plt.show()

HS_L_NE = HanSoloTable[HanSoloTable['Location'] == 'New England']
HS_L_NE['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = New England>')
plt.show()

HS_L_SEC = HanSoloTable[HanSoloTable['Location'] == 'South-East Central']
HS_L_SEC['Han Solo Opinion'].value_counts().plot(kind = 'bar', title = 'Han Solo Fans <Location = South-East Central>')
plt.show()


# In[116]:


LukeSkywalkerData = {'Luke Skywalker Opinion': starwars['Rank_Luke_Skywalker'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
LukeSkywalkerTable = pd.DataFrame(data = LukeSkywalkerData)
LukeSkywalkerTable = LukeSkywalkerTable[LukeSkywalkerTable['Luke Skywalker Opinion'] != 'No Comment']

#Gender
LS_Gender_M = LukeSkywalkerTable[LukeSkywalkerTable['Gender'] == 'Male']
LS_Gender_M['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Gender = Male>')
plt.show()

LS_Gender_F = LukeSkywalkerTable[LukeSkywalkerTable['Gender'] == 'Female']
LS_Gender_F['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Gender = Female>')
plt.show()

#Age
LS_Age_18_29 = LukeSkywalkerTable[LukeSkywalkerTable['Age'] == '18-29']
LS_Age_18_29

LS_Age_30_44 = LukeSkywalkerTable[LukeSkywalkerTable['Age'] == '30-44']
LS_Age_30_44

LS_Age_45_60 = LukeSkywalkerTable[LukeSkywalkerTable['Age'] == '45-60']
LS_Age_45_60

LS_Age_60 = LukeSkywalkerTable[LukeSkywalkerTable['Age'] == '> 60']
LS_Age_60

#Household Income
LS_HI_0 = LukeSkywalkerTable[LukeSkywalkerTable['Household Income'] == '$0 - $24,999']
LS_HI_0['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Household Income = $0 - $24,999>')
plt.show()

LS_HI_25 = LukeSkywalkerTable[LukeSkywalkerTable['Household Income'] == '$25,000 - $49,999']
LS_HI_25['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Household Income = $25,000 - $49,999>')
plt.show()

LS_HI_50 = LukeSkywalkerTable[LukeSkywalkerTable['Household Income'] == '$50,000 - $99,999']
LS_HI_50['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Household Income = $50,000 - $99,999>')
plt.show()

LS_HI_100 = LukeSkywalkerTable[LukeSkywalkerTable['Household Income'] == '$100,000 - $149,999']
LS_HI_100['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Household Income = $100,000 - $149,999>')
plt.show()

LS_HI_150 = LukeSkywalkerTable[LukeSkywalkerTable['Household Income'] == '$150,000+']
LS_HI_150['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Household Income = $150,000+>')
plt.show()

#Education
LS_E_LessHS = LukeSkywalkerTable[LukeSkywalkerTable['Education'] == 'Less than high school degree']
LS_E_LessHS['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Education = Less than high school degree>')
plt.show()

LS_E_HS = LukeSkywalkerTable[LukeSkywalkerTable['Education'] == 'High school degree']
LS_E_HS['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Education = High school degree>')
plt.show()

LS_E_C_AD = LukeSkywalkerTable[LukeSkywalkerTable['Education'] == 'Some college or Associate degree']
LS_E_C_AD['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Education = Some college or Associate degree>')
plt.show()

LS_E_BD = LukeSkywalkerTable[LukeSkywalkerTable['Education'] == 'Bachelor degree']
LS_E_BD['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Education = Bachelor degree>')
plt.show()

LS_E_GD = LukeSkywalkerTable[LukeSkywalkerTable['Education'] != 'Graduate degree']
LS_E_GD['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Education = Graduate degree>')
plt.show()

#Location
LS_L_NEC = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'North-East Central']
LS_L_NEC['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = North-East Central>')
plt.show()

LS_L_P = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'Pacific']
LS_L_P['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = Pacific>')
plt.show()

LS_L_SA = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'South Atlantic']
LS_L_SA['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = South Atlantic>')
plt.show()

LS_L_MA = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'Middle Atlantic']
LS_L_MA['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = Middle Atlantic>')
plt.show()

LS_L_SWC = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'South-West Central']
LS_L_SWC['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = South-West Central>')
plt.show()

LS_L_NWC = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'North-West Central']
LS_L_NWC['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = North-West Central>')
plt.show()

LS_L_NE = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'New England']
LS_L_NE['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = New England>')
plt.show()

LS_L_SEC = LukeSkywalkerTable[LukeSkywalkerTable['Location'] == 'South-East Central']
LS_L_SEC['Luke Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Luke Skywalker Fans <Location = South-East Central>')
plt.show()


# 

# In[117]:


PrincessLeiaData = {'Princess Leia Opinion': starwars['Rank_Princess_Leia'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
PrincessLeiaTable = pd.DataFrame(data = PrincessLeiaData)
PrincessLeiaTable = PrincessLeiaTable[PrincessLeiaTable['Princess Leia Opinion'] != 'No Comment']

#Gender
PL_Gender_M = PrincessLeiaTable[PrincessLeiaTable['Gender'] == 'Male']
PL_Gender_M['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Gender = Male>')
plt.show()

PL_Gender_F = PrincessLeiaTable[PrincessLeiaTable['Gender'] == 'Female']
PL_Gender_F['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Gender = Female>')
plt.show()

#Age
PL_Age_18_29 = PrincessLeiaTable[PrincessLeiaTable['Age'] == '18-29']
PL_Age_18_29

PL_Age_30_44 = PrincessLeiaTable[PrincessLeiaTable['Age'] == '30-44']
PL_Age_30_44

PL_Age_45_60 = PrincessLeiaTable[PrincessLeiaTable['Age'] == '45-60']
PL_Age_45_60

PL_Age_60 = PrincessLeiaTable[PrincessLeiaTable['Age'] == '> 60']
PL_Age_60

#Household Income
PL_HI_0 = PrincessLeiaTable[PrincessLeiaTable['Household Income'] == '$0 - $24,999']
PL_HI_0['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Household Income = $0 - $24,999>')
plt.show()

PL_HI_25 = PrincessLeiaTable[PrincessLeiaTable['Household Income'] == '$25,000 - $49,999']
PL_HI_25['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Household Income = $25,000 - $49,999>')
plt.show()

PL_HI_50 = PrincessLeiaTable[PrincessLeiaTable['Household Income'] == '$50,000 - $99,999']
PL_HI_50['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Household Income = $50,000 - $99,999>')
plt.show()

PL_HI_100 = PrincessLeiaTable[PrincessLeiaTable['Household Income'] == '$100,000 - $149,999']
PL_HI_100['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Household Income = $100,000 - $149,999>')
plt.show()

PL_HI_150 = PrincessLeiaTable[PrincessLeiaTable['Household Income'] == '$150,000+']
PL_HI_150['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Household Income = $150,000+>')
plt.show()

#Education
PL_E_LessHS = PrincessLeiaTable[PrincessLeiaTable['Education'] == 'Less than high school degree']
PL_E_LessHS['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Education = Less than high school degree>')
plt.show()

PL_E_HS = PrincessLeiaTable[PrincessLeiaTable['Education'] == 'High school degree']
PL_E_HS['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Education = High school degree>')
plt.show()

PL_E_C_AD = PrincessLeiaTable[PrincessLeiaTable['Education'] == 'Some college or Associate degree']
PL_E_C_AD['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Education = Some college or Associate degree>')
plt.show()

PL_E_BD = PrincessLeiaTable[PrincessLeiaTable['Education'] == 'Bachelor degree']
PL_E_BD['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Education = Bachelor degree>')
plt.show()

PL_E_GD = PrincessLeiaTable[PrincessLeiaTable['Education'] != 'Graduate degree']
PL_E_GD['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Education = Graduate degree>')
plt.show()

#Location
PL_L_NEC = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'North-East Central']
PL_L_NEC['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = North-East Central>')
plt.show()

PL_L_P = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'Pacific']
PL_L_P['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = Pacific>')
plt.show()

PL_L_SA = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'South Atlantic']
PL_L_SA['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = South Atlantic>')
plt.show()

PL_L_MA = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'Middle Atlantic']
PL_L_MA['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = Middle Atlantic>')
plt.show()

PL_L_SWC = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'South-West Central']
PL_L_SWC['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = South-West Central>')
plt.show()

PL_L_NWC = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'North-West Central']
PL_L_NWC['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = North-West Central>')
plt.show()

PL_L_NE = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'New England']
PL_L_NE['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = New England>')
plt.show()

PL_L_SEC = PrincessLeiaTable[PrincessLeiaTable['Location'] == 'South-East Central']
PL_L_SEC['Princess Leia Opinion'].value_counts().plot(kind = 'bar', title = 'Princess Leia Fans <Location = South-East Central>')
plt.show()


# In[118]:


AnakinSkywalkerData = {'Anakin Skywalker Opinion': starwars['Rank_Anakin_Skywalker'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
AnakinSkywalkerTable = pd.DataFrame(data = AnakinSkywalkerData)
AnakinSkywalkerTable = AnakinSkywalkerTable[AnakinSkywalkerTable['Anakin Skywalker Opinion'] != 'No Comment']

#Gender
AS_Gender_M = AnakinSkywalkerTable[AnakinSkywalkerTable['Gender'] == 'Male']
AS_Gender_M['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Gender = Male>')
plt.show()

AS_Gender_F = AnakinSkywalkerTable[AnakinSkywalkerTable['Gender'] == 'Female']
AS_Gender_F['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Gender = Female>')
plt.show()

#Age
AS_Age_18_29 = AnakinSkywalkerTable[AnakinSkywalkerTable['Age'] == '18-29']
AS_Age_18_29

AS_Age_30_44 = AnakinSkywalkerTable[AnakinSkywalkerTable['Age'] == '30-44']
AS_Age_30_44

AS_Age_45_60 = AnakinSkywalkerTable[AnakinSkywalkerTable['Age'] == '45-60']
AS_Age_45_60

AS_Age_60 = AnakinSkywalkerTable[AnakinSkywalkerTable['Age'] == '> 60']
AS_Age_60

#Household Income
AS_HI_0 = AnakinSkywalkerTable[AnakinSkywalkerTable['Household Income'] == '$0 - $24,999']
AS_HI_0['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Household Income = $0 - $24,999>')
plt.show()

AS_HI_25 = AnakinSkywalkerTable[AnakinSkywalkerTable['Household Income'] == '$25,000 - $49,999']
AS_HI_25['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Household Income = $25,000 - $49,999>')
plt.show()

AS_HI_50 = AnakinSkywalkerTable[AnakinSkywalkerTable['Household Income'] == '$50,000 - $99,999']
AS_HI_50['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Household Income = $50,000 - $99,999>')
plt.show()

AS_HI_100 = AnakinSkywalkerTable[AnakinSkywalkerTable['Household Income'] == '$100,000 - $149,999']
AS_HI_100['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Household Income = $100,000 - $149,999>')
plt.show()

AS_HI_150 = AnakinSkywalkerTable[AnakinSkywalkerTable['Household Income'] == '$150,000+']
AS_HI_150['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Household Income = $150,000+>')
plt.show()

#Education
AS_E_LessHS = AnakinSkywalkerTable[AnakinSkywalkerTable['Education'] == 'Less than high school degree']
AS_E_LessHS['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Education = Less than high school degree>')
plt.show()

AS_E_HS = AnakinSkywalkerTable[AnakinSkywalkerTable['Education'] == 'High school degree']
AS_E_HS['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Education = High school degree>')
plt.show()

AS_E_C_AD = AnakinSkywalkerTable[AnakinSkywalkerTable['Education'] == 'Some college or Associate degree']
AS_E_C_AD['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Education = Some college or Associate degree>')
plt.show()

AS_E_BD = AnakinSkywalkerTable[AnakinSkywalkerTable['Education'] == 'Bachelor degree']
AS_E_BD['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Education = Bachelor degree>')
plt.show()

AS_E_GD = AnakinSkywalkerTable[AnakinSkywalkerTable['Education'] != 'Graduate degree']
AS_E_GD['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Education = Graduate degree>')
plt.show()

#Location
AS_L_NEC = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'North-East Central']
AS_L_NEC['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = North-East Central>')
plt.show()

AS_L_P = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'Pacific']
AS_L_P['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = Pacific>')
plt.show()

AS_L_SA = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'South Atlantic']
AS_L_SA['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = South Atlantic>')
plt.show()

AS_L_MA = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'Middle Atlantic']
AS_L_MA['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = Middle Atlantic>')
plt.show()

AS_L_SWC = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'South-West Central']
AS_L_SWC['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = South-West Central>')
plt.show()

AS_L_NWC = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'North-West Central']
AS_L_NWC['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = North-West Central>')
plt.show()

AS_L_NE = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'New England']
AS_L_NE['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = New England>')
plt.show()

AS_L_SEC = AnakinSkywalkerTable[AnakinSkywalkerTable['Location'] == 'South-East Central']
AS_L_SEC['Anakin Skywalker Opinion'].value_counts().plot(kind = 'bar', title = 'Anakin Skywalker Fans <Location = South-East Central>')
plt.show()


# In[119]:


ObiwanKenobiData = {'Obiwan Kenobi Opinion': starwars['Rank_Obiwan_Kenobi'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
ObiwanKenobiTable = pd.DataFrame(data = ObiwanKenobiData)
ObiwanKenobiTable = ObiwanKenobiTable[ObiwanKenobiTable['Obiwan Kenobi Opinion'] != 'No Comment']

#Gender
OK_Gender_M = ObiwanKenobiTable[ObiwanKenobiTable['Gender'] == 'Male']
OK_Gender_M['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Gender = Male>')
plt.show()

OK_Gender_F = ObiwanKenobiTable[ObiwanKenobiTable['Gender'] == 'Female']
OK_Gender_F['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Gender = Female>')
plt.show()

#Age
OK_Age_18_29 = ObiwanKenobiTable[ObiwanKenobiTable['Age'] == '18-29']
OK_Age_18_29

OK_Age_30_44 = ObiwanKenobiTable[ObiwanKenobiTable['Age'] == '30-44']
OK_Age_30_44

OK_Age_45_60 = ObiwanKenobiTable[ObiwanKenobiTable['Age'] == '45-60']
OK_Age_45_60

OK_Age_60 = ObiwanKenobiTable[ObiwanKenobiTable['Age'] == '> 60']
OK_Age_60

#Household Income
OK_HI_0 = ObiwanKenobiTable[ObiwanKenobiTable['Household Income'] == '$0 - $24,999']
OK_HI_0['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Household Income = $0 - $24,999>')
plt.show()

OK_HI_25 = ObiwanKenobiTable[ObiwanKenobiTable['Household Income'] == '$25,000 - $49,999']
OK_HI_25['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Household Income = $25,000 - $49,999>')
plt.show()

OK_HI_50 = ObiwanKenobiTable[ObiwanKenobiTable['Household Income'] == '$50,000 - $99,999']
OK_HI_50['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Household Income = $50,000 - $99,999>')
plt.show()

OK_HI_100 = ObiwanKenobiTable[ObiwanKenobiTable['Household Income'] == '$100,000 - $149,999']
OK_HI_100['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Household Income = $100,000 - $149,999>')
plt.show()

OK_HI_150 = ObiwanKenobiTable[ObiwanKenobiTable['Household Income'] == '$150,000+']
OK_HI_150['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Household Income = $150,000+>')
plt.show()

#Education
OK_E_LessHS = ObiwanKenobiTable[ObiwanKenobiTable['Education'] == 'Less than high school degree']
OK_E_LessHS['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Education = Less than high school degree>')
plt.show()

OK_E_HS = ObiwanKenobiTable[ObiwanKenobiTable['Education'] == 'High school degree']
OK_E_HS['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Education = High school degree>')
plt.show()

OK_E_C_AD = ObiwanKenobiTable[ObiwanKenobiTable['Education'] == 'Some college or Associate degree']
OK_E_C_AD['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Education = Some college or Associate degree>')
plt.show()

OK_E_BD = ObiwanKenobiTable[ObiwanKenobiTable['Education'] == 'Bachelor degree']
OK_E_BD['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Education = Bachelor degree>')
plt.show()

OK_E_GD = ObiwanKenobiTable[ObiwanKenobiTable['Education'] != 'Graduate degree']
OK_E_GD['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Education = Graduate degree>')
plt.show()

#Location
OK_L_NEC = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'North-East Central']
OK_L_NEC['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = North-East Central>')
plt.show()

OK_L_P = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'Pacific']
OK_L_P['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = Pacific>')
plt.show()

OK_L_SA = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'South Atlantic']
OK_L_SA['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = South Atlantic>')
plt.show()

OK_L_MA = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'Middle Atlantic']
OK_L_MA['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = Middle Atlantic>')
plt.show()

OK_L_SWC = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'South-West Central']
OK_L_SWC['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = South-West Central>')
plt.show()

OK_L_NWC = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'North-West Central']
OK_L_NWC['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = North-West Central>')
plt.show()

OK_L_NE = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'New England']
OK_L_NE['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = New England>')
plt.show()

OK_L_SEC = ObiwanKenobiTable[ObiwanKenobiTable['Location'] == 'South-East Central']
OK_L_SEC['Obiwan Kenobi Opinion'].value_counts().plot(kind = 'bar', title = 'Obiwan Kenobi Fans <Location = South-East Central>')
plt.show()


# In[120]:


EmperorPalpatineData = {'Emperor Palpatine Opinion': starwars['Rank_Emperor_Palpatine'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
EmperorPalpatineTable = pd.DataFrame(data = EmperorPalpatineData)
EmperorPalpatineTable = EmperorPalpatineTable[EmperorPalpatineTable['Emperor Palpatine Opinion'] != 'No Comment']

#Gender
EP_Gender_M = EmperorPalpatineTable[EmperorPalpatineTable['Gender'] == 'Male']
EP_Gender_M['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Gender = Male>')
plt.show()

EP_Gender_F = EmperorPalpatineTable[EmperorPalpatineTable['Gender'] == 'Female']
EP_Gender_F['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Gender = Female>')
plt.show()

#Age
EP_Age_18_29 = EmperorPalpatineTable[EmperorPalpatineTable['Age'] == '18-29']
EP_Age_18_29

EP_Age_30_44 = EmperorPalpatineTable[EmperorPalpatineTable['Age'] == '30-44']
EP_Age_30_44

EP_Age_45_60 = EmperorPalpatineTable[EmperorPalpatineTable['Age'] == '45-60']
EP_Age_45_60

EP_Age_60 = EmperorPalpatineTable[EmperorPalpatineTable['Age'] == '> 60']
EP_Age_60

#Household Income
EP_HI_0 = EmperorPalpatineTable[EmperorPalpatineTable['Household Income'] == '$0 - $24,999']
EP_HI_0['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Household Income = $0 - $24,999>')
plt.show()

EP_HI_25 = EmperorPalpatineTable[EmperorPalpatineTable['Household Income'] == '$25,000 - $49,999']
EP_HI_25['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Household Income = $25,000 - $49,999>')
plt.show()

EP_HI_50 = EmperorPalpatineTable[EmperorPalpatineTable['Household Income'] == '$50,000 - $99,999']
EP_HI_50['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Household Income = $50,000 - $99,999>')
plt.show()

EP_HI_100 = EmperorPalpatineTable[EmperorPalpatineTable['Household Income'] == '$100,000 - $149,999']
EP_HI_100['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Household Income = $100,000 - $149,999>')
plt.show()

EP_HI_150 = EmperorPalpatineTable[EmperorPalpatineTable['Household Income'] == '$150,000+']
EP_HI_150['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Household Income = $150,000+>')
plt.show()

#Education
EP_E_LessHS = EmperorPalpatineTable[EmperorPalpatineTable['Education'] == 'Less than high school degree']
EP_E_LessHS['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Education = Less than high school degree>')
plt.show()

EP_E_HS = EmperorPalpatineTable[EmperorPalpatineTable['Education'] == 'High school degree']
EP_E_HS['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Education = High school degree>')
plt.show()

EP_E_C_AD = EmperorPalpatineTable[EmperorPalpatineTable['Education'] == 'Some college or Associate degree']
EP_E_C_AD['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Education = Some college or Associate degree>')
plt.show()

EP_E_BD = EmperorPalpatineTable[EmperorPalpatineTable['Education'] == 'Bachelor degree']
EP_E_BD['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Education = Bachelor degree>')
plt.show()

EP_E_GD = EmperorPalpatineTable[EmperorPalpatineTable['Education'] != 'Graduate degree']
EP_E_GD['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Education = Graduate degree>')
plt.show()

#Location
EP_L_NEC = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'North-East Central']
EP_L_NEC['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = North-East Central>')
plt.show()

EP_L_P = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'Pacific']
EP_L_P['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = Pacific>')
plt.show()

EP_L_SA = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'South Atlantic']
EP_L_SA['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = South Atlantic>')
plt.show()

EP_L_MA = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'Middle Atlantic']
EP_L_MA['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = Middle Atlantic>')
plt.show()

EP_L_SWC = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'South-West Central']
EP_L_SWC['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = South-West Central>')
plt.show()

EP_L_NWC = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'North-West Central']
EP_L_NWC['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = North-West Central>')
plt.show()

EP_L_NE = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'New England']
EP_L_NE['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = New England>')
plt.show()

EP_L_SEC = EmperorPalpatineTable[EmperorPalpatineTable['Location'] == 'South-East Central']
EP_L_SEC['Emperor Palpatine Opinion'].value_counts().plot(kind = 'bar', title = 'Emperor Palpatine Fans <Location = South-East Central>')
plt.show()


# In[121]:


DarthVaderData = {'Darth Vader Opinion': starwars['Rank_Darth_Vader'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
DarthVaderTable = pd.DataFrame(data = DarthVaderData)
DarthVaderTable = DarthVaderTable[DarthVaderTable['Darth Vader Opinion'] != 'No Comment']

#Gender
DV_Gender_M = DarthVaderTable[DarthVaderTable['Gender'] == 'Male']
DV_Gender_M['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Gender = Male>')
plt.show()

DV_Gender_F = DarthVaderTable[DarthVaderTable['Gender'] == 'Female']
DV_Gender_F['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Gender = Female>')
plt.show()

#Age
DV_Age_18_29 = DarthVaderTable[DarthVaderTable['Age'] == '18-29']
DV_Age_18_29

DV_Age_30_44 = DarthVaderTable[DarthVaderTable['Age'] == '30-44']
DV_Age_30_44

DV_Age_45_60 = DarthVaderTable[DarthVaderTable['Age'] == '45-60']
DV_Age_45_60

DV_Age_60 = DarthVaderTable[DarthVaderTable['Age'] == '> 60']
DV_Age_60

#Household Income
DV_HI_0 = DarthVaderTable[DarthVaderTable['Household Income'] == '$0 - $24,999']
DV_HI_0['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Household Income = $0 - $24,999>')
plt.show()

DV_HI_25 = DarthVaderTable[DarthVaderTable['Household Income'] == '$25,000 - $49,999']
DV_HI_25['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Household Income = $25,000 - $49,999>')
plt.show()

DV_HI_50 = DarthVaderTable[DarthVaderTable['Household Income'] == '$50,000 - $99,999']
DV_HI_50['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Household Income = $50,000 - $99,999>')
plt.show()

DV_HI_100 = DarthVaderTable[DarthVaderTable['Household Income'] == '$100,000 - $149,999']
DV_HI_100['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Household Income = $100,000 - $149,999>')
plt.show()

DV_HI_150 = DarthVaderTable[DarthVaderTable['Household Income'] == '$150,000+']
DV_HI_150['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Household Income = $150,000+>')
plt.show()

#Education
DV_E_LessHS = DarthVaderTable[DarthVaderTable['Education'] == 'Less than high school degree']
DV_E_LessHS['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Education = Less than high school degree>')
plt.show()

DV_E_HS = DarthVaderTable[DarthVaderTable['Education'] == 'High school degree']
DV_E_HS['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Education = High school degree>')
plt.show()

DV_E_C_AD = DarthVaderTable[DarthVaderTable['Education'] == 'Some college or Associate degree']
DV_E_C_AD['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Education = Some college or Associate degree>')
plt.show()

DV_E_BD = DarthVaderTable[DarthVaderTable['Education'] == 'Bachelor degree']
DV_E_BD['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Education = Bachelor degree>')
plt.show()

DV_E_GD = DarthVaderTable[DarthVaderTable['Education'] != 'Graduate degree']
DV_E_GD['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Education = Graduate degree>')
plt.show()

#Location
DV_L_NEC = DarthVaderTable[DarthVaderTable['Location'] == 'North-East Central']
DV_L_NEC['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = North-East Central>')
plt.show()

DV_L_P = DarthVaderTable[DarthVaderTable['Location'] == 'Pacific']
DV_L_P['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = Pacific>')
plt.show()

DV_L_SA = DarthVaderTable[DarthVaderTable['Location'] == 'South Atlantic']
DV_L_SA['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = South Atlantic>')
plt.show()

DV_L_MA = DarthVaderTable[DarthVaderTable['Location'] == 'Middle Atlantic']
DV_L_MA['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = Middle Atlantic>')
plt.show()

DV_L_SWC = DarthVaderTable[DarthVaderTable['Location'] == 'South-West Central']
DV_L_SWC['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = South-West Central>')
plt.show()

DV_L_NWC = DarthVaderTable[DarthVaderTable['Location'] == 'North-West Central']
DV_L_NWC['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = North-West Central>')
plt.show()

DV_L_NE = DarthVaderTable[DarthVaderTable['Location'] == 'New England']
DV_L_NE['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = New England>')
plt.show()

DV_L_SEC = DarthVaderTable[DarthVaderTable['Location'] == 'South-East Central']
DV_L_SEC['Darth Vader Opinion'].value_counts().plot(kind = 'bar', title = 'Darth Vader Fans <Location = South-East Central>')
plt.show()


# In[122]:


LandoCalrissianData = {'Lando Calrissian Opinion': starwars['Rank_Lando_Calrissian'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
LandoCalrissianTable = pd.DataFrame(data = LandoCalrissianData)
LandoCalrissianTable = LandoCalrissianTable[LandoCalrissianTable['Lando Calrissian Opinion'] != 'No Comment']

#Gender
LC_Gender_M = LandoCalrissianTable[LandoCalrissianTable['Gender'] == 'Male']
LC_Gender_M['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Gender = Male>')
plt.show()

LC_Gender_F = LandoCalrissianTable[LandoCalrissianTable['Gender'] == 'Female']
LC_Gender_F['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Gender = Female>')
plt.show()

#Age
LC_Age_18_29 = LandoCalrissianTable[LandoCalrissianTable['Age'] == '18-29']
LC_Age_18_29

LC_Age_30_44 = LandoCalrissianTable[LandoCalrissianTable['Age'] == '30-44']
LC_Age_30_44

LC_Age_45_60 = LandoCalrissianTable[LandoCalrissianTable['Age'] == '45-60']
LC_Age_45_60

LC_Age_60 = LandoCalrissianTable[LandoCalrissianTable['Age'] == '> 60']
LC_Age_60

#Household Income
LC_HI_0 = LandoCalrissianTable[LandoCalrissianTable['Household Income'] == '$0 - $24,999']
LC_HI_0['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Household Income = $0 - $24,999>')
plt.show()

LC_HI_25 = LandoCalrissianTable[LandoCalrissianTable['Household Income'] == '$25,000 - $49,999']
LC_HI_25['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Household Income = $25,000 - $49,999>')
plt.show()

LC_HI_50 = LandoCalrissianTable[LandoCalrissianTable['Household Income'] == '$50,000 - $99,999']
LC_HI_50['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Household Income = $50,000 - $99,999>')
plt.show()

LC_HI_100 = LandoCalrissianTable[LandoCalrissianTable['Household Income'] == '$100,000 - $149,999']
LC_HI_100['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Household Income = $100,000 - $149,999>')
plt.show()

LC_HI_150 = LandoCalrissianTable[LandoCalrissianTable['Household Income'] == '$150,000+']
LC_HI_150['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Household Income = $150,000+>')
plt.show()

#Education
LC_E_LessHS = LandoCalrissianTable[LandoCalrissianTable['Education'] == 'Less than high school degree']
LC_E_LessHS['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Education = Less than high school degree>')
plt.show()

LC_E_HS = LandoCalrissianTable[LandoCalrissianTable['Education'] == 'High school degree']
LC_E_HS['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Education = High school degree>')
plt.show()

LC_E_C_AD = LandoCalrissianTable[LandoCalrissianTable['Education'] == 'Some college or Associate degree']
LC_E_C_AD['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Education = Some college or Associate degree>')
plt.show()

LC_E_BD = LandoCalrissianTable[LandoCalrissianTable['Education'] == 'Bachelor degree']
LC_E_BD['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Education = Bachelor degree>')
plt.show()

LC_E_GD = LandoCalrissianTable[LandoCalrissianTable['Education'] != 'Graduate degree']
LC_E_GD['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Education = Graduate degree>')
plt.show()

#Location
LC_L_NEC = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'North-East Central']
LC_L_NEC['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = North-East Central>')
plt.show()

LC_L_P = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'Pacific']
LC_L_P['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = Pacific>')
plt.show()

LC_L_SA = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'South Atlantic']
LC_L_SA['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = South Atlantic>')
plt.show()

LC_L_MA = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'Middle Atlantic']
LC_L_MA['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = Middle Atlantic>')
plt.show()

LC_L_SWC = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'South-West Central']
LC_L_SWC['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = South-West Central>')
plt.show()

LC_L_NWC = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'North-West Central']
LC_L_NWC['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = North-West Central>')
plt.show()

LC_L_NE = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'New England']
LC_L_NE['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = New England>')
plt.show()

LC_L_SEC = LandoCalrissianTable[LandoCalrissianTable['Location'] == 'South-East Central']
LC_L_SEC['Lando Calrissian Opinion'].value_counts().plot(kind = 'bar', title = 'Lando Calrissian Fans <Location = South-East Central>')
plt.show()


# In[123]:


BobaFettData = {'Boba Fett Opinion': starwars['Rank_Boba_Fett'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
BobaFettTable = pd.DataFrame(data = BobaFettData)
BobaFettTable = BobaFettTable[BobaFettTable['Boba Fett Opinion'] != 'No Comment']

#Gender
BF_Gender_M = BobaFettTable[BobaFettTable['Gender'] == 'Male']
BF_Gender_M['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Gender = Male>')
plt.show()

BF_Gender_F = BobaFettTable[BobaFettTable['Gender'] == 'Female']
BF_Gender_F['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Gender = Female>')
plt.show()

#Age
BF_Age_18_29 = BobaFettTable[BobaFettTable['Age'] == '18-29']
BF_Age_18_29

BF_Age_30_44 = BobaFettTable[BobaFettTable['Age'] == '30-44']
BF_Age_30_44

BF_Age_45_60 = BobaFettTable[BobaFettTable['Age'] == '45-60']
BF_Age_45_60

BF_Age_60 = BobaFettTable[BobaFettTable['Age'] == '> 60']
BF_Age_60

#Household Income
BF_HI_0 = BobaFettTable[BobaFettTable['Household Income'] == '$0 - $24,999']
BF_HI_0['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Household Income = $0 - $24,999>')
plt.show()

BF_HI_25 = BobaFettTable[BobaFettTable['Household Income'] == '$25,000 - $49,999']
BF_HI_25['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Household Income = $25,000 - $49,999>')
plt.show()

BF_HI_50 = BobaFettTable[BobaFettTable['Household Income'] == '$50,000 - $99,999']
BF_HI_50['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Household Income = $50,000 - $99,999>')
plt.show()

BF_HI_100 = BobaFettTable[BobaFettTable['Household Income'] == '$100,000 - $149,999']
BF_HI_100['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Household Income = $100,000 - $149,999>')
plt.show()

BF_HI_150 = BobaFettTable[BobaFettTable['Household Income'] == '$150,000+']
BF_HI_150['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Household Income = $150,000+>')
plt.show()

#Education
BF_E_LessHS = BobaFettTable[BobaFettTable['Education'] == 'Less than high school degree']
BF_E_LessHS['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Education = Less than high school degree>')
plt.show()

BF_E_HS = BobaFettTable[BobaFettTable['Education'] == 'High school degree']
BF_E_HS['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Education = High school degree>')
plt.show()

BF_E_C_AD = BobaFettTable[BobaFettTable['Education'] == 'Some college or Associate degree']
BF_E_C_AD['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Education = Some college or Associate degree>')
plt.show()

BF_E_BD = BobaFettTable[BobaFettTable['Education'] == 'Bachelor degree']
BF_E_BD['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Education = Bachelor degree>')
plt.show()

BF_E_GD = BobaFettTable[BobaFettTable['Education'] != 'Graduate degree']
BF_E_GD['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Education = Graduate degree>')
plt.show()

#Location
BF_L_NEC = BobaFettTable[BobaFettTable['Location'] == 'North-East Central']
BF_L_NEC['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = North-East Central>')
plt.show()

BF_L_P = BobaFettTable[BobaFettTable['Location'] == 'Pacific']
BF_L_P['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = Pacific>')
plt.show()

BF_L_SA = BobaFettTable[BobaFettTable['Location'] == 'South Atlantic']
BF_L_SA['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = South Atlantic>')
plt.show()

BF_L_MA = BobaFettTable[BobaFettTable['Location'] == 'Middle Atlantic']
BF_L_MA['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = Middle Atlantic>')
plt.show()

BF_L_SWC = BobaFettTable[BobaFettTable['Location'] == 'South-West Central']
BF_L_SWC['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = South-West Central>')
plt.show()

BF_L_NWC = BobaFettTable[BobaFettTable['Location'] == 'North-West Central']
BF_L_NWC['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = North-West Central>')
plt.show()

BF_L_NE = BobaFettTable[BobaFettTable['Location'] == 'New England']
BF_L_NE['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = New England>')
plt.show()

BF_L_SEC = BobaFettTable[BobaFettTable['Location'] == 'South-East Central']
BF_L_SEC['Boba Fett Opinion'].value_counts().plot(kind = 'bar', title = 'Boba Fett Fans <Location = South-East Central>')
plt.show()


# In[124]:


C3POData = {'C-3PO Opinion': starwars['Rank_C3PO'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
C3POTable = pd.DataFrame(data = C3POData)
C3POTable = C3POTable[C3POTable['C-3PO Opinion'] != 'No Comment']

#Gender
CP_Gender_M = C3POTable[C3POTable['Gender'] == 'Male']
CP_Gender_M['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Gender = Male>')
plt.show()

CP_Gender_F = C3POTable[C3POTable['Gender'] == 'Female']
CP_Gender_F['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Gender = Female>')
plt.show()

#Age
CP_Age_18_29 = C3POTable[C3POTable['Age'] == '18-29']
CP_Age_18_29

CP_Age_30_44 = C3POTable[C3POTable['Age'] == '30-44']
CP_Age_30_44

CP_Age_45_60 = C3POTable[C3POTable['Age'] == '45-60']
CP_Age_45_60

CP_Age_60 = C3POTable[C3POTable['Age'] == '> 60']
CP_Age_60

#Household Income
CP_HI_0 = C3POTable[C3POTable['Household Income'] == '$0 - $24,999']
CP_HI_0['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Household Income = $0 - $24,999>')
plt.show()

CP_HI_25 = C3POTable[C3POTable['Household Income'] == '$25,000 - $49,999']
CP_HI_25['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Household Income = $25,000 - $49,999>')
plt.show()

CP_HI_50 = C3POTable[C3POTable['Household Income'] == '$50,000 - $99,999']
CP_HI_50['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Household Income = $50,000 - $99,999>')
plt.show()

CP_HI_100 = C3POTable[C3POTable['Household Income'] == '$100,000 - $149,999']
CP_HI_100['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Household Income = $100,000 - $149,999>')
plt.show()

CP_HI_150 = C3POTable[C3POTable['Household Income'] == '$150,000+']
CP_HI_150['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Household Income = $150,000+>')
plt.show()

#Education
CP_E_LessHS = C3POTable[C3POTable['Education'] == 'Less than high school degree']
CP_E_LessHS['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Education = Less than high school degree>')
plt.show()

CP_E_HS = C3POTable[C3POTable['Education'] == 'High school degree']
CP_E_HS['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Education = High school degree>')
plt.show()

CP_E_C_AD = C3POTable[C3POTable['Education'] == 'Some college or Associate degree']
CP_E_C_AD['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Education = Some college or Associate degree>')
plt.show()

CP_E_BD = C3POTable[C3POTable['Education'] == 'Bachelor degree']
CP_E_BD['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Education = Bachelor degree>')
plt.show()

CP_E_GD = C3POTable[C3POTable['Education'] != 'Graduate degree']
CP_E_GD['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Education = Graduate degree>')
plt.show()

#Location
CP_L_NEC = C3POTable[C3POTable['Location'] == 'North-East Central']
CP_L_NEC['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = North-East Central>')
plt.show()

CP_L_P = C3POTable[C3POTable['Location'] == 'Pacific']
CP_L_P['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = Pacific>')
plt.show()

CP_L_SA = C3POTable[C3POTable['Location'] == 'South Atlantic']
CP_L_SA['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = South Atlantic>')
plt.show()

CP_L_MA = C3POTable[C3POTable['Location'] == 'Middle Atlantic']
CP_L_MA['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = Middle Atlantic>')
plt.show()

CP_L_SWC = C3POTable[C3POTable['Location'] == 'South-West Central']
CP_L_SWC['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = South-West Central>')
plt.show()

CP_L_NWC = C3POTable[C3POTable['Location'] == 'North-West Central']
CP_L_NWC['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = North-West Central>')
plt.show()

CP_L_NE = C3POTable[C3POTable['Location'] == 'New England']
CP_L_NE['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = New England>')
plt.show()

CP_L_SEC = C3POTable[C3POTable['Location'] == 'South-East Central']
CP_L_SEC['C-3PO Opinion'].value_counts().plot(kind = 'bar', title = 'C-3PO Fans <Location = South-East Central>')
plt.show()


# In[125]:


R2D2Data = {'RD D2 Opinion': starwars['Rank_R2_D2'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
R2D2Table = pd.DataFrame(data = R2D2Data)
R2D2Table = R2D2Table[R2D2Table['RD D2 Opinion'] != 'No Comment']

#Gender
RD_Gender_M = R2D2Table[R2D2Table['Gender'] == 'Male']
RD_Gender_M['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Gender = Male>')
plt.show()

RD_Gender_F = R2D2Table[R2D2Table['Gender'] == 'Female']
RD_Gender_F['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Gender = Female>')
plt.show()

#Age
RD_Age_18_29 = R2D2Table[R2D2Table['Age'] == '18-29']
RD_Age_18_29

RD_Age_30_44 = R2D2Table[R2D2Table['Age'] == '30-44']
RD_Age_30_44

RD_Age_45_60 = R2D2Table[R2D2Table['Age'] == '45-60']
RD_Age_45_60

RD_Age_60 = R2D2Table[R2D2Table['Age'] == '> 60']
RD_Age_60

#Household Income
RD_HI_0 = R2D2Table[R2D2Table['Household Income'] == '$0 - $24,999']
RD_HI_0['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Household Income = $0 - $24,999>')
plt.show()

RD_HI_25 = R2D2Table[R2D2Table['Household Income'] == '$25,000 - $49,999']
RD_HI_25['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Household Income = $25,000 - $49,999>')
plt.show()

RD_HI_50 = R2D2Table[R2D2Table['Household Income'] == '$50,000 - $99,999']
RD_HI_50['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Household Income = $50,000 - $99,999>')
plt.show()

RD_HI_100 = R2D2Table[R2D2Table['Household Income'] == '$100,000 - $149,999']
RD_HI_100['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Household Income = $100,000 - $149,999>')
plt.show()

RD_HI_150 = R2D2Table[R2D2Table['Household Income'] == '$150,000+']
RD_HI_150['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Household Income = $150,000+>')
plt.show()

#Education
RD_E_LessHS = R2D2Table[R2D2Table['Education'] == 'Less than high school degree']
RD_E_LessHS['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Education = Less than high school degree>')
plt.show()

RD_E_HS = R2D2Table[R2D2Table['Education'] == 'High school degree']
RD_E_HS['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Education = High school degree>')
plt.show()

RD_E_C_AD = R2D2Table[R2D2Table['Education'] == 'Some college or Associate degree']
RD_E_C_AD['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Education = Some college or Associate degree>')
plt.show()

RD_E_BD = R2D2Table[R2D2Table['Education'] == 'Bachelor degree']
RD_E_BD['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Education = Bachelor degree>')
plt.show()

RD_E_GD = R2D2Table[R2D2Table['Education'] != 'Graduate degree']
RD_E_GD['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Education = Graduate degree>')
plt.show()

#Location
RD_L_NEC = R2D2Table[R2D2Table['Location'] == 'North-East Central']
RD_L_NEC['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = North-East Central>')
plt.show()

RD_L_P = R2D2Table[R2D2Table['Location'] == 'Pacific']
RD_L_P['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = Pacific>')
plt.show()

RD_L_SA = R2D2Table[R2D2Table['Location'] == 'South Atlantic']
RD_L_SA['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = South Atlantic>')
plt.show()

RD_L_MA = R2D2Table[R2D2Table['Location'] == 'Middle Atlantic']
RD_L_MA['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = Middle Atlantic>')
plt.show()

RD_L_SWC = R2D2Table[R2D2Table['Location'] == 'South-West Central']
RD_L_SWC['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = South-West Central>')
plt.show()

RD_L_NWC = R2D2Table[R2D2Table['Location'] == 'North-West Central']
RD_L_NWC['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = North-West Central>')
plt.show()

RD_L_NE = R2D2Table[R2D2Table['Location'] == 'New England']
RD_L_NE['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = New England>')
plt.show()

RD_L_SEC = R2D2Table[R2D2Table['Location'] == 'South-East Central']
RD_L_SEC['RD D2 Opinion'].value_counts().plot(kind = 'bar', title = 'RD D2 Fans <Location = South-East Central>')
plt.show()


# In[126]:


JarJarBinksData = {'Jar Jar Binks Opinion': starwars['Rank_Jar_Jar_Binks'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
JarJarBinksTable = pd.DataFrame(data = JarJarBinksData)
JarJarBinksTable = JarJarBinksTable[JarJarBinksTable['Jar Jar Binks Opinion'] != 'No Comment']

#Gender
JJB_Gender_M = JarJarBinksTable[JarJarBinksTable['Gender'] == 'Male']
JJB_Gender_M['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Gender = Male>')
plt.show()

JJB_Gender_F = JarJarBinksTable[JarJarBinksTable['Gender'] == 'Female']
JJB_Gender_F['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Gender = Female>')
plt.show()

#Age
JJB_Age_18_29 = JarJarBinksTable[JarJarBinksTable['Age'] == '18-29']
JJB_Age_18_29

JJB_Age_30_44 = JarJarBinksTable[JarJarBinksTable['Age'] == '30-44']
JJB_Age_30_44

JJB_Age_45_60 = JarJarBinksTable[JarJarBinksTable['Age'] == '45-60']
JJB_Age_45_60

JJB_Age_60 = JarJarBinksTable[JarJarBinksTable['Age'] == '> 60']
JJB_Age_60

#Household Income
JJB_HI_0 = JarJarBinksTable[JarJarBinksTable['Household Income'] == '$0 - $24,999']
JJB_HI_0['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Household Income = $0 - $24,999>')
plt.show()

JJB_HI_25 = JarJarBinksTable[JarJarBinksTable['Household Income'] == '$25,000 - $49,999']
JJB_HI_25['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Household Income = $25,000 - $49,999>')
plt.show()

JJB_HI_50 = JarJarBinksTable[JarJarBinksTable['Household Income'] == '$50,000 - $99,999']
JJB_HI_50['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Household Income = $50,000 - $99,999>')
plt.show()

JJB_HI_100 = JarJarBinksTable[JarJarBinksTable['Household Income'] == '$100,000 - $149,999']
JJB_HI_100['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Household Income = $100,000 - $149,999>')
plt.show()

JJB_HI_150 = JarJarBinksTable[JarJarBinksTable['Household Income'] == '$150,000+']
JJB_HI_150['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Household Income = $150,000+>')
plt.show()

#Education
JJB_E_LessHS = JarJarBinksTable[JarJarBinksTable['Education'] == 'Less than high school degree']
JJB_E_LessHS['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Education = Less than high school degree>')
plt.show()

JJB_E_HS = JarJarBinksTable[JarJarBinksTable['Education'] == 'High school degree']
JJB_E_HS['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Education = High school degree>')
plt.show()

JJB_E_C_AD = JarJarBinksTable[JarJarBinksTable['Education'] == 'Some college or Associate degree']
JJB_E_C_AD['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Education = Some college or Associate degree>')
plt.show()

JJB_E_BD = JarJarBinksTable[JarJarBinksTable['Education'] == 'Bachelor degree']
JJB_E_BD['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Education = Bachelor degree>')
plt.show()

JJB_E_GD = JarJarBinksTable[JarJarBinksTable['Education'] != 'Graduate degree']
JJB_E_GD['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Education = Graduate degree>')
plt.show()

#Location
JJB_L_NEC = JarJarBinksTable[JarJarBinksTable['Location'] == 'North-East Central']
JJB_L_NEC['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = North-East Central>')
plt.show()

JJB_L_P = JarJarBinksTable[JarJarBinksTable['Location'] == 'Pacific']
JJB_L_P['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = Pacific>')
plt.show()

JJB_L_SA = JarJarBinksTable[JarJarBinksTable['Location'] == 'South Atlantic']
JJB_L_SA['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = South Atlantic>')
plt.show()

JJB_L_MA = JarJarBinksTable[JarJarBinksTable['Location'] == 'Middle Atlantic']
JJB_L_MA['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = Middle Atlantic>')
plt.show()

JJB_L_SWC = JarJarBinksTable[JarJarBinksTable['Location'] == 'South-West Central']
JJB_L_SWC['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = South-West Central>')
plt.show()

JJB_L_NWC = JarJarBinksTable[JarJarBinksTable['Location'] == 'North-West Central']
JJB_L_NWC['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = North-West Central>')
plt.show()

JJB_L_NE = JarJarBinksTable[JarJarBinksTable['Location'] == 'New England']
JJB_L_NE['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = New England>')
plt.show()

JJB_L_SEC = JarJarBinksTable[JarJarBinksTable['Location'] == 'South-East Central']
JJB_L_SEC['Jar Jar Binks Opinion'].value_counts().plot(kind = 'bar', title = 'Jar Jar Binks Fans <Location = South-East Central>')
plt.show()


# In[127]:


PadmeAmidalasData = {'Padme Amidalas Opinion': starwars['Rank_Padme_Amidala'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
PadmeAmidalasTable = pd.DataFrame(data = PadmeAmidalasData)
PadmeAmidalasTable = PadmeAmidalasTable[PadmeAmidalasTable['Padme Amidalas Opinion'] != 'No Comment']

#Gender
PA_Gender_M = PadmeAmidalasTable[PadmeAmidalasTable['Gender'] == 'Male']
PA_Gender_M['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Gender = Male>')
plt.show()

PA_Gender_F = PadmeAmidalasTable[PadmeAmidalasTable['Gender'] == 'Female']
PA_Gender_F['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Gender = Female>')
plt.show()

#Age
PA_Age_18_29 = PadmeAmidalasTable[PadmeAmidalasTable['Age'] == '18-29']
PA_Age_18_29

PA_Age_30_44 = PadmeAmidalasTable[PadmeAmidalasTable['Age'] == '30-44']
PA_Age_30_44

PA_Age_45_60 = PadmeAmidalasTable[PadmeAmidalasTable['Age'] == '45-60']
PA_Age_45_60

PA_Age_60 = PadmeAmidalasTable[PadmeAmidalasTable['Age'] == '> 60']
PA_Age_60

#Household Income
PA_HI_0 = PadmeAmidalasTable[PadmeAmidalasTable['Household Income'] == '$0 - $24,999']
PA_HI_0['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Household Income = $0 - $24,999>')
plt.show()

PA_HI_25 = PadmeAmidalasTable[PadmeAmidalasTable['Household Income'] == '$25,000 - $49,999']
PA_HI_25['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Household Income = $25,000 - $49,999>')
plt.show()

PA_HI_50 = PadmeAmidalasTable[PadmeAmidalasTable['Household Income'] == '$50,000 - $99,999']
PA_HI_50['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Household Income = $50,000 - $99,999>')
plt.show()

PA_HI_100 = PadmeAmidalasTable[PadmeAmidalasTable['Household Income'] == '$100,000 - $149,999']
PA_HI_100['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Household Income = $100,000 - $149,999>')
plt.show()

PA_HI_150 = PadmeAmidalasTable[PadmeAmidalasTable['Household Income'] == '$150,000+']
PA_HI_150['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Household Income = $150,000+>')
plt.show()

#Education
PA_E_LessHS = PadmeAmidalasTable[PadmeAmidalasTable['Education'] == 'Less than high school degree']
PA_E_LessHS['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Education = Less than high school degree>')
plt.show()

PA_E_HS = PadmeAmidalasTable[PadmeAmidalasTable['Education'] == 'High school degree']
PA_E_HS['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Education = High school degree>')
plt.show()

PA_E_C_AD = PadmeAmidalasTable[PadmeAmidalasTable['Education'] == 'Some college or Associate degree']
PA_E_C_AD['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Education = Some college or Associate degree>')
plt.show()

PA_E_BD = PadmeAmidalasTable[PadmeAmidalasTable['Education'] == 'Bachelor degree']
PA_E_BD['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Education = Bachelor degree>')
plt.show()

PA_E_GD = PadmeAmidalasTable[PadmeAmidalasTable['Education'] != 'Graduate degree']
PA_E_GD['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Education = Graduate degree>')
plt.show()

#Location
PA_L_NEC = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'North-East Central']
PA_L_NEC['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = North-East Central>')
plt.show()

PA_L_P = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'Pacific']
PA_L_P['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = Pacific>')
plt.show()

PA_L_SA = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'South Atlantic']
PA_L_SA['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = South Atlantic>')
plt.show()

PA_L_MA = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'Middle Atlantic']
PA_L_MA['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = Middle Atlantic>')
plt.show()

PA_L_SWC = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'South-West Central']
PA_L_SWC['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = South-West Central>')
plt.show()

PA_L_NWC = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'North-West Central']
PA_L_NWC['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = North-West Central>')
plt.show()

PA_L_NE = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'New England']
PA_L_NE['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = New England>')
plt.show()

PA_L_SEC = PadmeAmidalasTable[PadmeAmidalasTable['Location'] == 'South-East Central']
PA_L_SEC['Padme Amidalas Opinion'].value_counts().plot(kind = 'bar', title = 'Padme Amidalas Fans <Location = South-East Central>')
plt.show()


# In[128]:


YodaData = {'Yoda Opinion': starwars['Rank_Yoda'],
                   'Gender': starwars['Gender'],
                   'Age': starwars['Age'],
                   'Household Income': starwars['Household_Income'],
                   'Education': starwars['Education'],
                   'Location': starwars['Location']
                  }
YodaTable = pd.DataFrame(data = YodaData)
YodaTable = YodaTable[YodaTable['Yoda Opinion'] != 'No Comment']

#Gender
Y_Gender_M = YodaTable[YodaTable['Gender'] == 'Male']
Y_Gender_M['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Gender = Male>')
plt.show()

Y_Gender_F = YodaTable[YodaTable['Gender'] == 'Female']
Y_Gender_F['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Gender = Female>')
plt.show()

#Age
Y_Age_18_29 = YodaTable[YodaTable['Age'] == '18-29']
Y_Age_18_29

Y_Age_30_44 = YodaTable[YodaTable['Age'] == '30-44']
Y_Age_30_44

Y_Age_45_60 = YodaTable[YodaTable['Age'] == '45-60']
Y_Age_45_60

Y_Age_60 = YodaTable[YodaTable['Age'] == '> 60']
Y_Age_60

#Household Income
Y_HI_0 = YodaTable[YodaTable['Household Income'] == '$0 - $24,999']
Y_HI_0['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Household Income = $0 - $24,999>')
plt.show()

Y_HI_25 = YodaTable[YodaTable['Household Income'] == '$25,000 - $49,999']
Y_HI_25['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Household Income = $25,000 - $49,999>')
plt.show()

Y_HI_50 = YodaTable[YodaTable['Household Income'] == '$50,000 - $99,999']
Y_HI_50['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Household Income = $50,000 - $99,999>')
plt.show()

Y_HI_100 = YodaTable[YodaTable['Household Income'] == '$100,000 - $149,999']
Y_HI_100['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Household Income = $100,000 - $149,999>')
plt.show()

Y_HI_150 = YodaTable[YodaTable['Household Income'] == '$150,000+']
Y_HI_150['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Household Income = $150,000+>')
plt.show()

#Education
Y_E_LessHS = YodaTable[YodaTable['Education'] == 'Less than high school degree']
Y_E_LessHS['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Education = Less than high school degree>')
plt.show()

Y_E_HS = YodaTable[YodaTable['Education'] == 'High school degree']
Y_E_HS['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Education = High school degree>')
plt.show()

Y_E_C_AD = YodaTable[YodaTable['Education'] == 'Some college or Associate degree']
Y_E_C_AD['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Education = Some college or Associate degree>')
plt.show()

Y_E_BD = YodaTable[YodaTable['Education'] == 'Bachelor degree']
Y_E_BD['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Education = Bachelor degree>')
plt.show()

Y_E_GD = YodaTable[YodaTable['Education'] != 'Graduate degree']
Y_E_GD['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Education = Graduate degree>')
plt.show()

#Location
Y_L_NEC = YodaTable[YodaTable['Location'] == 'North-East Central']
Y_L_NEC['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = North-East Central>')
plt.show()

Y_L_P = YodaTable[YodaTable['Location'] == 'Pacific']
Y_L_P['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = Pacific>')
plt.show()

Y_L_SA = YodaTable[YodaTable['Location'] == 'South Atlantic']
Y_L_SA['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = South Atlantic>')
plt.show()

Y_L_MA = YodaTable[YodaTable['Location'] == 'Middle Atlantic']
Y_L_MA['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = Middle Atlantic>')
plt.show()

Y_L_SWC = YodaTable[YodaTable['Location'] == 'South-West Central']
Y_L_SWC['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = South-West Central>')
plt.show()

Y_L_NWC = YodaTable[YodaTable['Location'] == 'North-West Central']
Y_L_NWC['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = North-West Central>')
plt.show()

Y_L_NE = YodaTable[YodaTable['Location'] == 'New England']
Y_L_NE['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = New England>')
plt.show()

Y_L_SEC = YodaTable[YodaTable['Location'] == 'South-East Central']
Y_L_SEC['Yoda Opinion'].value_counts().plot(kind = 'bar', title = 'Yoda Fans <Location = South-East Central>')
plt.show()

