from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from time import sleep
import logging

driver = webdriver.Chrome(executable_path="C:\\Users\\CHUDY\\Documents\\=PJWSTK\\SEM_7\\TAU\\ITN_TAU\\Selenium\\webDrivers\\Chrome\\chromedriver.exe")

driver.get('https://www.ikea.com/pl/pl/')
sleep(1)
searchField = driver.find_element_by_class_name('search-field__input')
sleep(1)
searchField_2 = driver.find_element_by_class_name('search-field__input')
sleep(1)
searchField_2.send_keys('banana')
sleep(1)
searchResults = driver.find_element_by_class_name('universal-item__link--universal-item__title--product')
sleep(1)
searchResults.click()
sleep(2)
addToList = driver.find_element_by_class_name('range-revamp-btn--full-width')
sleep(1)
addToList.click()
sleep(1)
shoppingListItem = driver.find_element_by_class_name('hnf-header__shopping-list-link')
sleep(2)
shoppingListLink = shoppingListItem.find_element_by_class_name('hnf-btn--icon-tertiary')
sleep(5)
shoppingListLink.click()
sleep(5)
shoppingCheckItem = driver.find_element_by_class_name('shopping-list-item')
sleep(0.5)
shoppingCheckItemName = shoppingCheckItem.find_element_by_tag_name('a')
sleep(0.5)
print(shoppingCheckItemName.text)


#searchElement = driver.find_element_by_class_name('search-wrapper')
#searchElementInput = searchElement.find_element_by_tag_name('input').send_keys('banana')


