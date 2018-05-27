/*
 * File: app/view/viewport.js
 *
 * This file was generated by Sencha Architect version 4.2.3.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 6.5.x Classic library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 6.5.x Classic. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('byzCorp.view.viewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.viewport',

    requires: [
        'byzCorp.view.viewportViewModel',
        'byzCorp.view.menuPanel',
        'Ext.tab.Panel',
        'Ext.tab.Tab',
        'Ext.Img',
        'Ext.button.Split',
        'Ext.menu.Menu',
        'Ext.menu.Item'
    ],

    viewModel: {
        type: 'viewport'
    },
    height: 250,
    width: 400,
    layout: 'border',

    items: [
        {
            xtype: 'tabpanel',
            region: 'center',
            id: 'mainTabPanel',
            activeTab: 0,
            items: [
                {
                    xtype: 'panel',
                    layout: 'border',
                    title: 'Güncel Durum',
                    tabConfig: {
                        xtype: 'tab',
                        iconCls: 'fa fa-tachometer'
                    },
                    items: [
                        {
                            xtype: 'panel',
                            region: 'north',
                            height: 110,
                            margin: '2 0 0 0',
                            layout: 'border',
                            header: false,
                            items: [
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningGreen-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Bugün Tahsil Edilecek<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>11.341,77 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningMagenta-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Tahsilat Zamanı Geçen<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningYellow-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Tahsilat Zamanı Geçen<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'center',
                                    ui: 'dashboardWarningRed-small',
                                    text: '<b><font size="2" color="white">Ödeme Zamanı Geçen<br>Borçlar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            region: 'north',
                            height: 110,
                            margin: '2 0 0 0',
                            layout: 'border',
                            header: false,
                            items: [
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningGreen-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Bugün Tahsil Edilecek<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>11.341,77 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningMagenta-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Tahsilat Zamanı Geçen<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningYellow-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Tahsilat Zamanı Geçen<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'center',
                                    ui: 'dashboardWarningRed-small',
                                    text: '<b><font size="2" color="white">Ödeme Zamanı Geçen<br>Borçlar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            region: 'north',
                            height: 110,
                            margin: '2 0 0 0',
                            layout: 'border',
                            header: false,
                            items: [
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningGreen-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Bugün Tahsil Edilecek<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>11.341,77 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningMagenta-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Tahsilat Zamanı Geçen<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'west',
                                    margin: '0 2 0 0',
                                    ui: 'dashboardWarningYellow-small',
                                    width: 150,
                                    text: '<b><font size="2" color="white">Tahsilat Zamanı Geçen<br>Alacaklar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    region: 'center',
                                    ui: 'dashboardWarningRed-small',
                                    text: '<b><font size="2" color="white">Ödeme Zamanı Geçen<br>Borçlar Toplamı</font><br><font size="6" color="white"><br>6.550,50 <span>&#8378;</span></b></font></br>',
                                    textAlign: 'right'
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            xtype: 'container',
            region: 'north',
            height: 50,
            layout: 'border',
            items: [
                {
                    xtype: 'image',
                    region: 'west',
                    margin: 2,
                    style: '\'border: 0px;border-radius: 100px;',
                    width: 50,
                    src: 'resources/images/1.png'
                },
                {
                    xtype: 'splitbutton',
                    region: 'east',
                    margin: 2,
                    style: '\'border: 0px;border-radius: 10px;',
                    ui: 'default-small',
                    width: 73,
                    iconCls: 'fa fa-power-off',
                    text: '',
                    menu: {
                        xtype: 'menu',
                        items: [
                            {
                                xtype: 'menuitem',
                                iconCls: 'fa fa-lock',
                                text: 'Ekranı Kilitle'
                            },
                            {
                                xtype: 'menuitem',
                                iconCls: 'fa fa-user-circle',
                                text: 'Kullanıcı Değiştir'
                            }
                        ]
                    }
                }
            ]
        },
        {
            xtype: 'menuPanel',
            width: 212,
            collapsible: true,
            region: 'west',
            split: true
        }
    ]

});