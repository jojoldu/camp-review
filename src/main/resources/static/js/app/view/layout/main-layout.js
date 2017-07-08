/**
 * Created by jojoldu@gmail.com on 2017. 7. 8.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

import Woowahan from 'woowahan';
import Template from './main-layout.hbs';
import HeaderView from './header';
import Footer from './footer.hbs';

export default Woowahan.View.create('MainLayout', {
    template: Template,

    initialize() {
        this.super();
    },

    viewDidMount() {
        const FooterView = Woowahan.View.create("FooterView", {template: Footer});

        this.addView("#main-header", HeaderView, this.getModel());
        this.addView("#main-footer", FooterView, this.getModel());
    },

});