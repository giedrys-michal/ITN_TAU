from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from time import sleep
import logging

logging.basicConfig(format='%(asctime)s - %(name)s - %(levelname)s - %(message)s', level=logging.INFO)

logger = logging.getLogger('ikea_logger')

logger.warning('Celowo opóźnione wykonywanie instrukcji uwzględniające ładowanie się elementów serwisu.')

logger.info('Testowana przeglądarka Chrome')
driver = webdriver.Chrome(executable_path="C:\\Users\\CHUDY\\Documents\\=PJWSTK\\SEM_7\\TAU\\ITN_TAU\\Selenium\\webDrivers\\Chrome\\chromedriver.exe")

logger.info('Przechodzę na stronę IKEA')
driver.get('https://www.ikea.com/pl/pl/')
sleep(2)

logger.info('Wyszukanie frazy "banana"')
searchField = driver.find_element_by_class_name('search-field__input')
sleep(0.5)
searchField_2 = driver.find_element_by_class_name('search-field__input')
sleep(0.5)
searchField_2.send_keys('banana')
sleep(1)

logger.info('Przejście na podstronę produktu')
searchResults = driver.find_element_by_class_name('universal-item__link--universal-item__title--product')
sleep(0.5)
searchResults.click()
sleep(3)

logger.info('Dodanie produktu do listy zakupów')
addToList = driver.find_element_by_class_name('range-revamp-btn--full-width')
sleep(0.5)
addToList.click()
sleep(5)

logger.info('Przejście na podstronę listy zakupów')
shoppingListItem = driver.find_element_by_class_name('hnf-header__shopping-list-link')
sleep(0.5)
shoppingListLink = shoppingListItem.find_element_by_class_name('hnf-btn--icon-tertiary')
sleep(0.5)
shoppingListLink.click()
sleep(5)

logger.info('Sczytanie i wypisanie nazwy produktu z listy')
shoppingCheckItem = driver.find_element_by_class_name('shopping-list-item')
sleep(0.5)
shoppingCheckItemName = shoppingCheckItem.find_element_by_tag_name('a')
sleep(0.5)
print(shoppingCheckItemName.text)

driver.close()
