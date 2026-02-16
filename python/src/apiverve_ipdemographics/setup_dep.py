from setuptools import setup, find_packages

setup(
    name='apiverve_ipdemographics',
    version='1.1.14',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='IP Demographics combines IP geolocation with Census demographic data to provide demographic information for any IP address. Get location, income, education, and housing data based on the IP's geographic location.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/ipdemographics?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
