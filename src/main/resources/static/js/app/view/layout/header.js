/**
 * Created by jojoldu@gmail.com on 2017. 7. 9.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

import Woowahan from 'woowahan';
import Template from './header.hbs';

export default Woowahan.View.create('HeaderView', {
    template: Template,
    events: {
        'click .mobile-side-menu': 'toggleMobileMenuAccordion',
        'click .mmenu-toggle-btn': 'toggleMobileMenu',
        'click #mobile-menu-overlay': 'toggleMobileMenu',
        'click .search-toggle': 'toggleSearchDropdown'
    },

    initialize() {

    },

    // Mobile menu accordion
    toggleMobileMenuAccordion() {
        const closestLi = $(this).closest('li');

        if (closestLi.find('ul').length) {
            closestLi.children('ul').slideToggle(300, function () {
                closestLi.toggleClass('open');
            });
        }
    },

    // Mobile menu show/hide
    toggleMobileMenu() {
        $('.body').toggleClass('mmenu-open');
    },

    // Search Dropdown Toggle
    toggleSearchDropdown() {
        this.$el.find('.header-search-wrapper').toggleClass('open');
    }


});